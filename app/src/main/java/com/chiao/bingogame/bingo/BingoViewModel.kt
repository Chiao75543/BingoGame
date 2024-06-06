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

    fun createNewGame(size : Int){
        viewModelScope.launch{
            _bingoState.value = BingoModel(size)
            Log.d("BingoViewModel", "New game created with size: $size")
        }
    }
}