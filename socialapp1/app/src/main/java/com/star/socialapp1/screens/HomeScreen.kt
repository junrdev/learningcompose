package com.star.socialapp1.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.star.socialapp1.model.User.Companion.getUsers
import com.star.socialapp1.widgets.CustomTopBar


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(modifier = Modifier.fillMaxWidth().fillMaxHeight(), topBar = {
        CustomTopBar(modifier = Modifier.fillMaxWidth(), currentUser = getUsers().first(), navController = navController)
    }) {

    }

}