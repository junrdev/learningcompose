package com.star.noteslearnnav.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsScreen(navController: NavController, note: String?) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier,
                backgroundColor = Color.Gray,
                elevation = 5.dp
            ) {

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Text(text ="Note Details")
                }
            }
        }//top bar end

    ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                SingleNoteView(note)
            }
        }
    }

@Composable
fun SingleNoteView(note: String?) {

    Surface(modifier = Modifier, shape = RoundedCornerShape(12.dp), color = Color.DarkGray, elevation = 12.dp) {
        Column(
            modifier = Modifier.padding(25.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Note", style = MaterialTheme.typography.h3)
            Divider(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 7.dp))
            Text(text = note.toString(), style = MaterialTheme.typography.body2, color = Color.White ,modifier = Modifier.padding(top = 12.dp))

        }
    }

    //delete or save
    Surface(modifier = Modifier.padding(top = 15.dp)) {

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(
                modifier = Modifier,
                elevation = ButtonDefaults.elevation(6.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Edit")
            }

            Spacer(modifier = Modifier.width(70.dp))

            Button(
                modifier = Modifier,
                elevation = ButtonDefaults.elevation(6.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Delete")
            }
        }
    }
}
