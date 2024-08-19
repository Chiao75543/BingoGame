package com.chiao.bingogame.bingo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


// This viewmodel to pass the value from BingoModel to BingoView.
class BingoViewModel : ViewModel() {
    private val _bingoState = MutableStateFlow<BingoModel?>(null)
    val bingoState : StateFlow<BingoModel?> = _bingoState

    private val _randomNumber = MutableStateFlow<Int?>(null)
    val randomNumber : StateFlow<Int?> = _randomNumber

    private val _isBingo = MutableStateFlow<Boolean>(false)
    val isBingo : StateFlow<Boolean> = _isBingo

    fun createNewGame(size : Int){
        viewModelScope.launch{
            _bingoState.value = BingoModel(size)
        }
    }

    fun generateRandomNumber(){
        viewModelScope.launch {
            _randomNumber.value = _bingoState.value?.generateRandomNumber()
            changeBackground(_randomNumber.value)
            _isBingo.value = isBingo()
        }
    }

    private fun changeBackground(generatedNumber: Int?) {
        _bingoState.value?.let { bingoModel ->
            val updateBoardStatus = bingoModel.gameBoard.map { status ->
                if (status.number == generatedNumber) status.copy(isMatched = true) else status
            }
            _bingoState.value = bingoModel.copy(gameBoard = updateBoardStatus)
        }
    }

    private fun isBingo() : Boolean{
        _bingoState.value?.let { bingoModel ->
            val size = bingoModel.size
            val board = bingoModel.gameBoard.chunked(size) //可將list分為size大小為一組

            // 檢查row
            if (board.any { row -> row.all {it.isMatched} }) return true

            // 檢查column
            for (column in 0..<size){
                if ((0 ..<size).all { row -> board[row][column].isMatched }) return true
            }

            // 檢查對角線
            if ((0..<size).all {index -> board[index][index].isMatched}) return true
            if ((0 ..<size).all {index -> board[index][size - index - 1].isMatched}) return true

        }
        return false
    }

    fun resetGame(){
        val defaultSize = 3
        createNewGame(_bingoState.value?.size ?: defaultSize )
        _isBingo.value = false
    }
}