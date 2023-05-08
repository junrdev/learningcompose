package com.star.socialapp1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.star.socialapp1.screens.ChatViewScreen
import com.star.socialapp1.screens.HomeScreen
import com.star.socialapp1.screens.ProfileScreen


@Composable
fun AppNavigator() {

    //nav controller
    val navController = rememberNavController()

    //nav host
    NavHost(navController = navController, startDestination = Screens.HomeScreen.name) {

        //resolve the different screens

        //home screen
        composable(route = Screens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }

        //profile screen
        composable(route = Screens.ProfileScreen.name) {
            ProfileScreen(navController = navController)
        }

        //chat screen
        composable(route = Screens.ChatViewScreen.name) {
            ChatViewScreen(navController = navController)
        }

    }
}

