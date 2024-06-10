package com.chiao.bingogame.bingo

import android.util.Log
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

    fun createNewGame(size : Int){
        viewModelScope.launch{
            _bingoState.value = BingoModel(size)
        }
    }

    fun generateRandomNumber(){
        viewModelScope.launch {
            _randomNumber.value = _bingoState.value?.generateRandomNumber()
        }
    }

    fun changeBackground(){

    }

    fun isBingo(){}
}