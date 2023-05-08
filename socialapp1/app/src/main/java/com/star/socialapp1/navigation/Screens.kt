package com.star.socialapp1.navigation

enum class Screens {

    HomeScreen,
    ProfileScreen,
    ChatViewScreen;

    companion object{

        fun fromRoute(route: String?){
            //mapping different routes
            when(route?.substringBefore("/")){

                HomeScreen.name -> HomeScreen
                ProfileScreen.name -> ProfileScreen
                ChatViewScreen.name -> ChatViewScreen

                null -> HomeScreen

                else -> throw IllegalArgumentException("Invalid route $route")
            }
        }
    }
}