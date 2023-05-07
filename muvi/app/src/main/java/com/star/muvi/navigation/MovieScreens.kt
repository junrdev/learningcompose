package com.star.muvi.navigation

enum class MovieScreens {
    HomeScreen,
    DetailsScreen;

    companion object{

        //used for navigating between different screens
        fun fromRoute(route : String?) : MovieScreens=
            when(route?.substringBefore("/")){
                HomeScreen.name -> HomeScreen
                DetailsScreen.name -> DetailsScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Failed to parse route $route")
            }
    }
}