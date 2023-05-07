package com.star.muvi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.star.muvi.screens.home.HomeScreen
import com.star.muvi.screens.details.DetailsScreen

@Composable
fun MovieNavigation() {

    val navController = rememberNavController()

    //navhost hosts all of the destinations
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name){

        composable(MovieScreens.HomeScreen.name){
            //where we wanna go
            HomeScreen(navController = navController)
        }

        //passing data while navigating takes the form of routing as in APIs
        composable(
            MovieScreens.DetailsScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") {type = NavType.StringType})
        ){
            //we use the backstack entry o retrieve information passed from previous screens
            backStackEntry ->
            DetailsScreen(navController = navController, backStackEntry.arguments?.getString("movie"))
        }
    }
}