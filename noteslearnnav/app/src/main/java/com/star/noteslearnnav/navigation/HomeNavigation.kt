package com.star.noteslearnnav.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.star.noteslearnnav.screens.DetailsScreen
import com.star.noteslearnnav.screens.HomeScreen

@Composable
fun HomeNavigation() {

    val navController = rememberNavController();

    NavHost(navController = navController, startDestination = Screens.HomeScreen.name ){

        //routing the screens

        //home screen
        composable(route = Screens.HomeScreen.name){
            HomeScreen(navController = navController)
        }


        //details screen
        //pass the note details
        composable(
            route = Screens.NoteDetails.name + "/{note}",
            arguments = listOf(navArgument(name = "note") { type = NavType.StringType })
        ){
            DetailsScreen(navController = navController, note = it.arguments?.getString("note"))
        }

    }
}