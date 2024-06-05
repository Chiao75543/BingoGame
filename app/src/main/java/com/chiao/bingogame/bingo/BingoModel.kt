package com.chiao.bingogame.bingo

import kotlin.random.Random


// 處理從MainActivity所接收到的大小來產生亂數
class BingoModel {
    fun generateRandomNumbers (size : Int) : List<Int>{
        val totalNumbers = size * size
        // 用Set的特性來確保不會產生重複數字
        val numbersList = mutableSetOf<Int>()

        for (i in 0..<totalNumbers){
            numbersList.add(Random.nextInt(0,100))
        }

        return numbersList.toList()
    }
}