package com.chiao.bingogame.bingo

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


// This view receive the size value from main activity and change the size of bingo game.
class BingoView(private val viewModel: BingoViewModel) {


    @Composable
    fun GameScreen(){

        val game = viewModel.bingoState.collectAsState().value
        val randomNumber =  viewModel.randomNumber.collectAsState().value

        game?.let {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp)
                    .padding(top = 10.dp)
            ) {
                it.gameBoard.chunked(it.size).forEach{
                    row -> Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .border(1.dp, Color.Gray)
                            .padding(vertical = 1.dp)
                    ) {
                        row.forEach{ number ->
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .weight(1f)
                                    .aspectRatio(1f)
                                    .border(1.dp, Color.Gray)
                                    .padding(8.dp)
                            ){
                                Text(
                                    text = number.toString(),
                                    fontSize = 20.sp,
                                    modifier = Modifier.padding(15.dp),
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier
                    .height(70.dp)
                    .padding(top = 20.dp)
                )
                Text("Number : ${randomNumber ?: "Not generated."} ", fontSize = 24.sp)
                Button(
                    onClick = { viewModel.generateRandomNumber()},
                    modifier = Modifier
                        .padding(30.dp)
                        .padding(top = 30.dp)
                        .width(150.dp),
                    colors = ButtonDefaults.buttonColors(Color.Gray),
                ) {
                    Text("Generate")
                }
            }
        }
    }

}

