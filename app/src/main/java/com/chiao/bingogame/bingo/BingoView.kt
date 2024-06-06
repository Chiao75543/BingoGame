package com.chiao.bingogame.bingo

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


// This view receive the size value from main activity and change the size of bingo game.
class BingoView(private val viewModel: BingoViewModel) {

    @Composable
    fun GameScreen(){

//        val game = viewModel.bingoState.collectAsState(initial = null).value
//
//        Log.d("GameScreen","$game")
//
//        game?.let {
//            Log.d("GameScreen", "Displaying game with size: ${it.size}")
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(32.dp)
//            ) {
//                it.gameBoard.chunked(it.size).forEach{
//                    row -> Row (
//                        horizontalArrangement = Arrangement.SpaceEvenly
//                    ) {
//                        row.forEach{
//                            number -> Text(
//                                text = number.toString(),
//                                modifier = Modifier.padding(8.dp)
//                            )
//                        }
//                    }
//
//                }
//            }
//        } ?: Log.d("GameScreen", "Game data is null")
    }

}

