package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Quadrant()
                }
            }
        }
    }
}

@Composable
fun Quadrant() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        QuadrantRow(
            listOf(Color.Green, Color.Yellow),
            listOf(
                listOf("Text composable", "Displays text and follows Material Design guidelines."),
                listOf("Image composable", "Creates a composable that lays out and draws a given Painter class object.")
            ),
            modifier = Modifier.weight(1f))
        QuadrantRow(
            listOf(Color.Cyan, Color.LightGray),
            listOf(
                listOf("Row composable", "A layout composable that places its children in a horizontal sequence."),
                listOf("Column composable", "A layout composable that places its children in a vertical sequence.")
            ),
            modifier = Modifier.weight(1f))
    }
}

@Composable
fun QuadrantRow(rowColors: List<Color>, rowTexts: List<List<String>>, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxSize()
    ) {
        ComposeCardColumn(rowColors[0], rowTexts[0], Modifier.weight(1f))
        ComposeCardColumn(rowColors[1], rowTexts[1], Modifier.weight(1f))
    }
}

@Composable
fun ComposeCardColumn(color: Color, textList: List<String>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = textList[0],
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = textList[1],
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        Quadrant()
    }
}