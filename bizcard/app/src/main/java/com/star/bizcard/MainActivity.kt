package com.star.bizcard

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.star.bizcard.ui.theme.BizcardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizcardTheme {
                CreateBizCard()
            }
        }
    }
}

@Composable
fun CreateBizCard() {

    var isClicked = remember {
        mutableStateOf(false)
    }

    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            elevation = 8.dp,
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            backgroundColor = Color.White
        ) {

            Column(
                modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfileImage()
                Divider(modifier = Modifier.padding(top = 10.dp))
                DetailsView()
                Button(onClick = { isClicked.value = !isClicked.value }, modifier = Modifier) {
                    Text(text = "Portfolio", style = MaterialTheme.typography.button)
                }

                if (isClicked.value)
                    ShowProjects()
                else
                    Box(){}
            }


        }
    }
}

@Composable
fun ShowProjects() {
    Box(modifier = Modifier
        .fillMaxHeight()
        .padding(5.dp)
        .fillMaxWidth()){

        Surface(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(6.dp),
            border = BorderStroke(2.dp, Color.LightGray)
        ){
            Portfolio(listOf("project 1","project 2","project 3","project 4","project 5"))
        }
    }
}

@Composable
fun Portfolio(listOf: List<String>) {
    LazyColumn {
        items(listOf){
            item -> 
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(),
                shape =  RectangleShape,
                elevation = 4.dp
            ) {

                Row (modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colors.surface)
                    .padding(16.dp)){

                    //image icon
                    ProfileImage(modifier = Modifier.size(70.dp))

                    Column (modifier = Modifier.padding(8.dp).align(Alignment.CenterVertically)){
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "Bazzzengahhh??!!", style = MaterialTheme.typography.body2)
                    }

                }
                }
            }

        }
    }

@Composable
fun DetailsView() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Brian Kidiga",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primary
            //TextStyle(fontSize = 44.sp, color = MaterialTheme.colors.primary)
        )

        Text(
            text = "Android compose programmer",
            style = MaterialTheme.typography.subtitle1
            //TextStyle(fontSize = 16.sp, color = Color.Black)
        )

        Text(
            text = "@dev_brianke",
            style = MaterialTheme.typography.subtitle1
            //TextStyle(fontSize = 16.sp, color = Color.Black)
        )
    }
}

@Composable
fun ProfileImage(modifier: Modifier = Modifier) {
    //profile image
    Surface(
        modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.Magenta),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {

        Image(
            painter = painterResource(id = R.drawable.profilepic),
            contentDescription = null,
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BizcardTheme {
    }
}