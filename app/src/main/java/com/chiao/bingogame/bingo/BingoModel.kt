package com.chiao.bingogame.bingo

import kotlin.random.Random


// 用於生成隨機數字提供給ViewModel
data class BingoModel(val size : Int) {
    val gameBoard : List<Int> = List(size * size) { Random.nextInt(1,100)}
}