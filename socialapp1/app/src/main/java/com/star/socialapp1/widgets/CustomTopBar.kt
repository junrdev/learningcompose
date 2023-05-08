package com.star.socialapp1.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomTopBar(modifier: Modifier = Modifier) {
    TopAppBar(modifier = modifier.fillMaxWidth()) {
        Text(text = "Home")
    }
}