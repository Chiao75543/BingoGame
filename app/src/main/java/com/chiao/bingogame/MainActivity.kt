package com.chiao.bingogame



import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chiao.bingogame.ui.theme.BingoGameTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chiao.bingogame.bingo.BingoView
import com.chiao.bingogame.bingo.BingoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BingoGameTheme {
                val navController = rememberNavController()
                AppNavGraph(navController = navController)
            }
        }
    }
}


@Composable

fun AppNavGraph(navController: NavHostController){
    val viewModel : BingoViewModel = viewModel()
    NavHost(navController = navController, startDestination = "main"){
        composable("main"){
            BeginScreen(navController,viewModel)
        }
        composable("game") {
            // 建立遊戲頁面
            BingoView(viewModel).GameScreen()
        }
    }
}

@Composable
fun BeginScreen(navController: NavHostController, viewModel: BingoViewModel){


    var textSize by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

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
                // 只能輸入數字
                if (it.isDigitsOnly()){
                    textSize = it
                }
            },
            label = { Text("Input the size",
                style = TextStyle(color = Color.Gray),
            )},
        )

        Button(onClick = {
                 textSize.toIntOrNull()?.let { size ->
                     if (size in 3..5){
                         viewModel.createNewGame(size)
                         navController.navigate("game")
                     }else{
                         Toast.makeText(context,"Please enter the size in 3~5",Toast.LENGTH_SHORT).show()
                     }
                 }
        },
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