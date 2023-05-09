package com.star.socialapp1.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.star.socialapp1.model.User
import com.star.socialapp1.ui.theme.btn_primary
import com.star.socialapp1.ui.theme.btn_secondary

@Composable
fun CustomTopBar(modifier: Modifier = Modifier, currentUser: User, navController: NavController) {

    val isSelected = remember {
        mutableStateOf(true)
    }

    TopAppBar(modifier = modifier
        .fillMaxWidth()
        .height(280.dp)
        .clip(
            CircleShape.copy(
                bottomStart = CornerSize(10.dp),
                bottomEnd = CornerSize(10.dp),
                topEnd = CornerSize(0.dp),
                topStart = CornerSize(0.dp)
            )
        ),
        elevation = 20.dp
    ) {

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
            ) {

                // user details and app logo
                Column(modifier = Modifier
                    .padding(10.dp)
                    .padding(end = 80.dp)) {

                    Text(
                        text = "Social App",
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier
                            .padding(start = 12.dp, bottom = 20.dp)
                    )

                    UserDetail(detail = currentUser.username, style = TextStyle(fontWeight = FontWeight.Bold))
                    UserDetail(currentUser.status.name)
                    UserDetail(currentUser.description)
                }

                //image and active status
                Box(modifier = Modifier.padding(end = 5.dp), contentAlignment = Alignment.Center){

                    Image(
                        painter = rememberAsyncImagePainter(
                            ImageRequest.Builder(LocalContext.current)
                                .data(data = currentUser.profile_picture)
                                .apply(block = fun ImageRequest.Builder.() {
                                    crossfade(true)
                                    crossfade(1000)
                                    transformations(CircleCropTransformation())
                                }).build()
                        ),
                        contentDescription = "User profile pic",
                        modifier = Modifier
                            .size(150.dp)

                    )
                    Text(text = "", modifier = Modifier
                        .clip(CircleShape)
                        .size(10.dp)
                        .background(Color.Green)
                        .align(Alignment.BottomEnd)
                        .padding(start = 0.dp))
                }
            }

            //buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                CustomButton(text = "Home", isSelected = isSelected.value){
                    //onclick handler
                    isSelected.value = !isSelected.value
                }

                CustomButton(text = "Clan", isSelected = isSelected.value){ isSelected.value = !isSelected.value }

                CustomButton(text = "Chats", isSelected = isSelected.value) { isSelected.value = !isSelected.value }

            }
        }

    }//end of top bar
}

@Composable
private fun UserDetail(detail: String, modifier: Modifier = Modifier, style: TextStyle = TextStyle()) {
    Text(
        text = detail,
        style = style,
        modifier = modifier.padding(start = 50.dp),
    )
}

@Composable
private fun CustomButton(text : String, isSelected : Boolean, onClick : () -> Unit ) {
    Box(
        modifier = Modifier
            .padding(5.dp)
            .clip(shape = CircleShape.copy(CornerSize(15.dp)))
            .background(if (isSelected) btn_primary else btn_secondary)
            .clickable { onClick() }
    ) {
        Text(
            text = text,
            style = TextStyle(color = Color.White, fontSize = 18.sp),
            modifier = Modifier
                .align(Alignment.Center)
                .padding(10.dp)
        )
    }
}