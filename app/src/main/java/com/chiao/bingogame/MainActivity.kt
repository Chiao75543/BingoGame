package com.chiao.bingogame


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chiao.bingogame.ui.theme.BingoGameTheme
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BingoGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BingoGame()
                }
            }
        }
    }
}


@Composable
fun BingoSizeSelection(){
    var textSize by remember {
        mutableStateOf("")
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "BingoGame", Modifier.padding(15.dp),
            style = TextStyle(fontSize = 30.sp))

        Text(text = "Please enter the size:",Modifier.padding(15.dp),
            style = TextStyle(fontSize = 20.sp)
        )

        TextField(value = textSize,
            onValueChange = {
                if (it.all {char -> char.isDigit() && it.toInt() in 1..9}){
                    textSize = it
                }
            },
            label = { Text("Input the size",
                style = TextStyle(color = Color.Gray),
            )},
        )

        Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(30.dp)
                    .width(150.dp),
                colors = ButtonDefaults.buttonColors(Color.Gray),
            content = {
                Text(text = "Play")
            }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun BingoGame() {
    BingoGameTheme {
       BingoSizeSelection()
    }
}