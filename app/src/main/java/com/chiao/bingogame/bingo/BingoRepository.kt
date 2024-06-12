package com.chiao.bingogame.bingo

import kotlin.random.Random


// 用於生成隨機數字提供給ViewModel
data class BingoModel (
    val size : Int,
    // 避免遊戲玩太久 只使用合適的範圍數字並打亂
    var gameBoard : List<BoardStatus> = List(size * size) {
        BoardStatus( it + 1)
    }) {
    fun generateRandomNumber() : Int{
        return Random.nextInt(1 , size * size + 1)
    }
}

// 用於紀錄bingo版上的狀態
data class BoardStatus (val number: Int, var isMatched : Boolean = false)
