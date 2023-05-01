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
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.star.tipapp.components.CustomInputField
import com.star.tipapp.ui.theme.TipappTheme
import com.star.tipapp.widgets.RoundIconButton

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                App {
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
        .padding(20.dp)
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
            Text(text = "$ $totalPerPerson", style = MaterialTheme.typography.h4, fontWeight = FontWeight.Bold)

            
        }
    }
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainContent() {
    var tipAmount = remember {
        mutableStateOf(0.0)
    }
    var totalPerPerson = remember {
        mutableStateOf(0.0)
    }

    var splitCount = remember {
        mutableStateOf(1)
    }


    BillForm(tipAmountValue= tipAmount, totalPerPersonState = totalPerPerson, splitCountState = splitCount)
}

@ExperimentalComposeUiApi
@Composable
fun BillForm(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
    splitCountState: MutableState<Int>,
    tipAmountValue : MutableState<Double>,
    totalPerPersonState : MutableState<Double>
) {

    val total = remember {
        mutableStateOf("")
    }

    val validState = remember(total.value) {
        total.value.trim().isNotEmpty()
    }

    val keyBoardController = LocalSoftwareKeyboardController.current


    var sliderPositionState by remember {
        mutableStateOf(0f)
    }

    var tipPercentage by remember {
        mutableStateOf(0)
    }

    TopCard(totalPerPerson = totalPerPersonState.value)

    Surface(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    ) {

        Column(
            modifier = Modifier.padding(23.dp),
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

                        RoundIconButton(
                            imageVector = Icons.Default.Clear,
                            onClick = {
                                if (splitCountState.value > 1) splitCountState.value-- else splitCountState.value = 1
                                totalPerPersonState.value = calculateTotalPerPerson(total.value.toDouble(), splitCountState.value, tipPercentage)
                            }
                        )

                        Text(
                            text = splitCountState.toString(),
                            modifier = Modifier
                                .align(alignment = Alignment.CenterVertically)
                                .padding(start = 9.dp, end = 9.dp)
                        )
                        RoundIconButton(imageVector = Icons.Default.Add, onClick = {
                            splitCountState.value++
                            totalPerPersonState.value = calculateTotalPerPerson(total.value.toDouble(), splitCountState.value, tipPercentage)
                        })

                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ){

                    Text(text = "Tip", modifier = Modifier.align(alignment = Alignment.CenterVertically))
                    Spacer(modifier = Modifier.width(170.dp))
                    Text(text = "$ $tipAmountValue", modifier = Modifier
                        .align(alignment = Alignment.CenterVertically)
                        .padding(end = 5.dp))
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    tipPercentage = (sliderPositionState*100).toInt()
                    Text(text = "$tipPercentage%")

                    Spacer(modifier = Modifier.height(20.dp))

                    Slider(
                        value = sliderPositionState,
                        onValueChange = { newVal ->
                            sliderPositionState = newVal
                            tipAmountValue.value = calculateTip(total.value.toDouble(), tipPercentage)
                            totalPerPersonState.value = calculateTotalPerPerson(total.value.toDouble(), splitCountState.value, tipPercentage)
                        },
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        steps = 10
                    )

                }
            }else
                Box {  }
            


        }
    }
}

fun calculateTip(total: Double, tipPercentage: Int): Double {
    return if (total > 1 && total.toString().isNotEmpty()) (total*tipPercentage)/100 else 0.0
}

fun calculateTotalPerPerson(total: Double, splitBy : Int, tipPercentage: Int) : Double{
    val bill = calculateTip(total, tipPercentage) + total
    return (bill/splitBy)
}