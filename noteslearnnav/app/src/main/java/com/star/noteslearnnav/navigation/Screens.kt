package com.star.noteslearnnav.navigation

enum class Screens {
    HomeScreen,
    NoteDetails;

    companion object{

        fun fromRoute(route : String?) : Screens = when(route?.substringBefore("/")){
            HomeScreen.name -> HomeScreen
            NoteDetails.name -> NoteDetails
            null -> HomeScreen
            else -> throw IllegalArgumentException("Unresolved route")
        }
    }
}