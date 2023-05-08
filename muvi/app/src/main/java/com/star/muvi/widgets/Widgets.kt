package com.star.muvi.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.star.muvi.model.Movie



@Composable
fun MovieRow(it: Movie, onItemClick : (String) -> Unit ={}) {

    var isExpanded by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable { onItemClick(it.id) },
        shape = RoundedCornerShape(CornerSize(12.dp)),
        elevation = 6.dp
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            //image
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp
            ) {

//                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "movie image")
                
                Image(painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(data = it.poster).apply(block = fun ImageRequest.Builder.() {
                        crossfade(true)
                        transformations(CircleCropTransformation())
                    }).build()
                ), contentDescription = "Image")

            }

            Column(modifier = Modifier.padding(4.dp)) {
                //text
                Text(text = it.title, style = MaterialTheme.typography.h6)
                Text(text = "Director : ${it.title}", style = MaterialTheme.typography.caption)
                Text(text = "Release : ${it.yearRelease}", style = MaterialTheme.typography.caption)


                AnimatedVisibility(visible = isExpanded) {
                    Column {
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 13.sp)){
                                append("Plot :")
                            }

                            withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 13.sp, fontWeight = FontWeight.Light)){
                                append(it.plot)
                            }
                        }, modifier = Modifier.padding(6.dp))
                        
                        Divider(modifier = Modifier.padding(7.dp))
                        
                        Text(text = "Director : ${it.director}", style = MaterialTheme.typography.caption)
                        Text(text = "Actors : ${it.actors}", style = MaterialTheme.typography.caption)
                        Text(text = "Rating : ${it.rating}", style = MaterialTheme.typography.caption)
                    }
                }


                //more arrow
                Icon(
                    imageVector = if(isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Down Arrow",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            isExpanded = !isExpanded
                        },
                    tint = Color.DarkGray
                )
            }



        }

    }
}
