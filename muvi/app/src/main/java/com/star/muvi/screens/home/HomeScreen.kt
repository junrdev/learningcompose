package com.star.muvi.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.star.muvi.navigation.MovieScreens

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Magenta, elevation = 5.dp ){
            Text(text = "Movies")
        }
    }) {
        MainContent(navController= navController)
    }
}

@Composable
fun MainContent(
    movieList: List<String> = listOf(
    "Avatar",
    "Piranha",
    "Big Bang"
),
navController: NavController) {


    Column(modifier = Modifier.padding(12.dp)) {

        LazyColumn {
            items(items = movieList){
                MovieRow(it){//this trailing lambda is an onclick handler function
                        movie ->
                    //passing the movie to the next screen by appending it to the route
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
                }
            }
        }
    }
}


@Composable
private fun MovieRow(it: String, onItemClick : (String) -> Unit ={}) {

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable { onItemClick(it) },
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

                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "movie image")

            }

            //text
            Text(text = it)
        }
    }
}
