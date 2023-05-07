package com.star.noteslearnnav.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.star.noteslearnnav.navigation.Screens
import com.star.noteslearnnav.ui.theme.*
import kotlin.random.Random

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(
        modifier = Modifier.fillMaxSize(), backgroundColor = resolveColor(), topBar = {
            TopAppBar(
                modifier = Modifier,
                backgroundColor = Color.Gray,
                elevation = 5.dp
            ) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                    Text(
                        text = "Your Notes",
                        modifier = Modifier.padding(start = 40.dp),
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }//top bar end
    ) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    NotesView(
                        navController = navController,
                        notes = listOf(
                            "Hello",
                            "world",
                            "hello there this is supposed to be a very very long note with meaningless information on how you can go and fuck yourself",
                            "How to fuck yourself 101",
                            "",
                            "Sh!t what did you expect",
                            "Am talking dirty??!!",
                            "Who cares Bruuh",
                            "Atleast I sincerely dont care",
                            "Fuck Off!!@>$",
                            "Click"
                        )
                    )
                }
    }
}

//list view
@Composable
fun NotesView(navController: NavController, notes: List<String>) {

    LazyColumn{
        items(items = notes){
            NoteCard(it){//onclick handler
                //navigate to note details

                //simple validation of the notes content
                val content = when{
                    it.isNotEmpty() -> it
                    else -> "$it Empty"
                }

                navController.navigate(route = Screens.NoteDetails.name+"/$content")
            }

        }
    }
}

//single card view
@Composable
fun NoteCard(it: String, onClickHandler: () -> Unit) {
    Surface(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .clickable { onClickHandler() },
        elevation = 5.dp,
        shape = RoundedCornerShape(CornerSize(10.dp))
    ) {
        Card(modifier = Modifier, elevation = 8.dp, backgroundColor = resolveColor()) {
            Text(text = it, style = MaterialTheme.typography.h6, modifier = Modifier.padding(12.dp))
        }
    }

}

fun resolveColor (): Color {
    val allcolor = listOf(c1,c2,c3,c4,c5)

    val index = (Random.nextInt(allcolor.size) % allcolor.size)

    return allcolor[index]
}

