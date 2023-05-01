package com.star.tipapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.star.tipapp.components.CustomInputField
import com.star.tipapp.ui.theme.TipappTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                App {
                    TopCard()
                    MainContent()
                }
        }
    }

}

@Composable
private fun App(content : @Composable ()-> Unit) {
    TipappTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column {
                content()
            }
        }
    }
}


@Composable
fun TopCard(totalPerPerson : Double = 134.00) {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .padding(12.dp)
        .clip(shape = CircleShape.copy(all = CornerSize(12.dp)))
        ,
        color = Color(0xFFE9D7F7)
    ) {

        var total = "%.2f".format(totalPerPerson)
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
        
            Text(text = "Total per person", style = MaterialTheme.typography.h5, fontWeight = FontWeight.SemiBold)
            Text(text = "$ $total", style = MaterialTheme.typography.h4, fontWeight = FontWeight.Bold)

            
        }
    }
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainContent() {

    BillForm{
        billAmt -> Log.d("AMT", "Amount $billAmt")
    }
}

@ExperimentalComposeUiApi
@Composable
fun BillForm(modifier: Modifier= Modifier, onValueChange : (String)->Unit = {}) {

    val total = remember {
        mutableStateOf("")
    }

    val validState = remember(total.value) {
        total.value.trim().isNotEmpty()
    }

    val keyBoardController = LocalSoftwareKeyboardController.current

    Surface(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    ) {

        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            CustomInputField(
                valueState = total,
                labelId ="Enter Bill",
                enabled = true,
                isSingleLine =true,
                onAction= KeyboardActions{

                    if(!validState) return@KeyboardActions

                    onValueChange(total.value.trim())

                    keyBoardController?.hide()
                }
            )
            
            if (validState){
                Row(
                    modifier = Modifier.padding(3.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Split",
                        modifier = Modifier.align(alignment = Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(120.dp))

                    Row(
                        modifier = Modifier.padding(horizontal = 3.dp),
                        horizontalArrangement = Arrangement.End
                    ) {



                    }
                }
            }else
                Box {  }
            
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TipappTheme {
    }
}