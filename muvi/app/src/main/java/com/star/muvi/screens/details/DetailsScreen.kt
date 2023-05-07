package com.star.muvi.screens.details

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsScreen(navController: NavHostController, movie: String?) {


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

                    Text(text = movie.toString(), fontWeight = FontWeight.Bold)
                }
            }
        },
        modifier = Modifier.height(100.dp)
    ) {

        Surface (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()){

            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Text(text = movie.toString(), style = MaterialTheme.typography.h5)
            }

        }
    }
}