package com.example.practicingcomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicingcomposedemo.ui.theme.PracticingComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticingComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceRollerApp()
                }
            }
        }
    }
}

@Composable
fun DiceRollerApp(){

    var result by remember {
        mutableIntStateOf(1)
    }
    val imageResources= when(result){
        1 -> R.drawable.dice_1
        2 ->  R.drawable.dice_2
        3 ->  R.drawable.dice_3
        4 ->  R.drawable.dice_4
        5 ->  R.drawable.dice_5
        else ->  R.drawable.dice_6
    }
    Column (verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = painterResource(id = imageResources),
            contentDescription = "Ludo Image",
            modifier = Modifier
                .size(150.dp)
        )
        Button(
            modifier = Modifier,
            onClick = {
                result = (1..6).random()
            }
        ) {
            Text(text = " $result")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    PracticingComposeDemoTheme{
       Column(modifier = Modifier.fillMaxSize(),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally) {
           DiceRollerApp()
       }
    }
}