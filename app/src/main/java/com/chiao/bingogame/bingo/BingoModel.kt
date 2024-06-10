package com.chiao.bingogame.bingo

import kotlin.random.Random


// 用於生成隨機數字提供給ViewModel
data class BingoModel (val size : Int) {
    // 避免遊戲玩太久 只使用合適的範圍數字並打亂
    val gameBoard : List<Int> = List(size * size) { Random.nextInt(1 , size * size) }

    fun generateRandomNumber() : Int{
        return Random.nextInt(1 , size * size)
    }
}

