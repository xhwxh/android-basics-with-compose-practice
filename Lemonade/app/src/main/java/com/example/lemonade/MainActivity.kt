package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import com.example.lemonade.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var state by remember { mutableStateOf(0) }
        var squeezeTimes by remember { mutableStateOf(0) }

        val title = when (state) {
            0 -> "Tap the lemon tree to select a lemon"
            1 -> "Keep tapping the lemon to squeeze it"
            2 -> "Tap the lemonade to drink it"
            3 -> "Tap the empty glass to start again"
            else -> "Tap the lemon tree to select a lemon"
        }

        val imageResId = when (state) {
            0 -> R.drawable.lemon_tree
            1 -> R.drawable.lemon_squeeze
            2 -> R.drawable.lemon_drink
            3 -> R.drawable.lemon_restart
            else -> 0
        }

        Text(
            text = title,
            fontSize = 18.sp
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp))
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier =
            Modifier
                .border(
                    width = 2.dp,
                    color = Color(red = 105, green = 205, blue = 216),
                    shape = Shapes.medium
                )
                .clickable {
                    when (state) {
                        0 -> {
                            state = 1
                            squeezeTimes = (2..4).random()
                        }
                        1 -> {
                            if (squeezeTimes > 0) {
                                squeezeTimes--
                            } else {
                                state = 2
                            }
                        }
                        2 -> state = 3
                        3 -> state = 0
                    }
                },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}