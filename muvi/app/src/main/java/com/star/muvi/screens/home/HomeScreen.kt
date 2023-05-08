package com.star.muvi.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.star.muvi.model.Movie
import com.star.muvi.model.getMovies
import com.star.muvi.navigation.MovieScreens
import com.star.muvi.widgets.MovieRow

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Magenta, elevation = 5.dp ){
            Text(text = "Movies")
        }
    }) {
        MainContent(navController= navController, movieList = getMovies())
    }
}

@Composable
fun MainContent(
    movieList: List<Movie>,
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


