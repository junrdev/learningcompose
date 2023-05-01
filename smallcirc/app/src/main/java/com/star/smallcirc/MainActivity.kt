package com.star.smallcirc

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.star.smallcirc.ui.theme.SmallcircTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmallcircTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@Composable
private fun MyApp() {

    var count by remember {
        mutableStateOf(0)
    }


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF54637A)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(text = "\$ $count", style = TextStyle(
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ))
            Spacer(modifier = Modifier.height(50.dp))
            CreateCircle(modifier = Modifier.clickable { count++ })

//            if (count > 10)
//                Text(text = "Gwaaap")
        }
    }
}

@Composable
fun CreateCircle(modifier: Modifier=Modifier) {
    Card(
        shape = CircleShape,
        modifier = modifier
            .padding(3.dp)
            .size(145.dp),
        elevation = 5.dp
    ) {
        
        Box(modifier =Modifier, contentAlignment = Alignment.Center){
            Text(text = "Click")
        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SmallcircTheme {
    }
}