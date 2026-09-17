package com.example.spacedroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spacedroid.ui.theme.Nes
import com.example.spacedroid.ui.theme.SpaceDroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpaceDroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComponentsScreen( modifier = Modifier.padding(innerPadding))
//                    GameOver(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ComponentsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF000000))
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically, // alinhamento vertical
            horizontalArrangement = Arrangement.SpaceEvenly // espaçamento horizontal
        ) {
            Text(
                text = "SCORE: 5000",
                color = Color(0xFFFFFFFF),
                fontSize = 13.sp,
                fontWeight = FontWeight.W700,
                fontFamily = Nes
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "LIVES:",
                color = Color(0xFFFFFFFF),
                fontSize = 13.sp,
                fontWeight = FontWeight.W700,
                fontFamily = Nes
            )

            repeat(3){
                Nave(modifier = Modifier.size(35.dp))
            }

        }
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(430.dp)
        ) {

            Droid(
                color = Color.Green,
                modifier = Modifier.size(75.dp)
            )
            Droid(
                color = Color.Red,
                modifier = Modifier.size(75.dp)
            )
            Droid(
                color = Color.Blue,
                modifier = Modifier.size(75.dp)
            )
            Droid(
                color = Color.Yellow,
                modifier = Modifier.size(75.dp)
            )
            Droid(
                color = Color.Green,
                modifier = Modifier.size(75.dp)
            )
        }

        Nave(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.CenterHorizontally)
        )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF3F3F3F))
                    .height(50.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "PRESS START",
                    color = Color(0xFFFFFFFF),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W700,
                    fontFamily = Nes
                )
            }

    }
}

@Composable
fun GameOver(modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF000000)),
        contentAlignment = Alignment.Center
    ){
        Row(verticalAlignment = Alignment.CenterVertically, // alinhamento vertical
            horizontalArrangement = Arrangement.SpaceEvenly // espaçamento horizontal
        ) {
            Droid(
                color = Color.Green,
                modifier = Modifier.size(75.dp)
            )
            Droid(
                color = Color.Red,
                modifier = Modifier.size(75.dp)
            )
            Droid(
                color = Color.Blue,
                modifier = Modifier.size(75.dp)
            )
            Droid(
                color = Color.Yellow,
                modifier = Modifier.size(75.dp)
            )
            Droid(
                color = Color.Green,
                modifier = Modifier.size(75.dp)
            )
        }

        Text(
            text = "GAME OVER",
            color = Color(0xFFFFFFFF),
            fontSize = 45.sp,
            fontWeight = FontWeight.W700,
            fontFamily = Nes
        )
    }
}

@Composable
fun Droid(color: Color, modifier: Modifier = Modifier){
    Image(
        modifier = modifier.padding(8.dp),
        painter = painterResource(R.drawable.alien),
        colorFilter = ColorFilter.tint(color = color),
        contentDescription = "Droid"
    )
}

@Composable
fun Nave(modifier: Modifier = Modifier){
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.nave),
        contentDescription = "Studio"
    )
}