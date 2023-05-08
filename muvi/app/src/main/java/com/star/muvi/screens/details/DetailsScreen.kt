package com.star.muvi.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.star.muvi.model.Movie
import com.star.muvi.model.getMovies
import com.star.muvi.widgets.MovieRow

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsScreen(navController: NavHostController, movieId: String?) {

    //getting the current movie from the list
    val currentMovie = getMovies().filter { it.id == movieId }

    Scaffold(
        topBar = {
            TopAppBar(modifier = Modifier, elevation = 9.dp) {
                Row (horizontalArrangement = Arrangement.Start){

                    //back button
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.clickable { navController.popBackStack() }
                    )

                    Spacer(modifier = Modifier.width(100.dp))

                    Text(text = currentMovie.first().title, fontWeight = FontWeight.Bold)
                }
            }
        },
        modifier = Modifier
    ) {

        Surface (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()){

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

//                Text(text = currentMovie.first().title)
                MovieRow(it = currentMovie.first())

                Spacer(modifier = Modifier.height(6.dp))
                Divider()

                Text(text = "Movie Images")

                HorizontalMovieImagesDisplay(currentMovie)

            }

        }
    }
}

@Composable
fun HorizontalMovieImagesDisplay(currentMovie: List<Movie>) {
    LazyRow {
        items(currentMovie.first().images) { img_url ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = 5.dp
            ) {

                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(
                            LocalContext.current
                        ).data(data = img_url).apply(block = fun ImageRequest.Builder.() {
                            crossfade(true)
                        }).build()
                    ), contentDescription = "Image"
                )
            }
        }
    }
}