package com.star.muvi.model

data class Movie(
    val id: String,
    val title : String,
    val yearRelease : String,
    val genre : String,
    val director : String,
    val actors : String,
    val plot : String,
    val poster : String,
    val images :List<String>,
    val rating  : Int = 4
)

fun getMovies() : List<Movie>{
    return listOf(
        Movie("11", "Hello world 1", "2021", "Action", "Brian","brian, Kidiga", "Action movie on a beautiful island by naruto uzumaki uchiha", "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/muviapp%2F0_0.webp?alt=media&token=2157b1ef-3026-4be1-a229-c082156c565f", listOf()),
        Movie("11", "Hello world", "2021", "Action", "Brian","brian, Kidiga", "Action movie on a beautiful island by naruto uzumaki uchiha", "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/muviapp%2F0_1.webp?alt=media&token=9b0ad7a8-6ebe-40ea-99ee-de87d2b3f80d", listOf()),
        Movie("11", "Hello world", "2021", "Action", "Brian","brian, Kidiga", "Action movie on a beautiful island by naruto uzumaki uchiha", "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/muviapp%2F0_2.webp?alt=media&token=8c66ccff-0931-4553-944e-555da655c825", listOf()),
        Movie("11", "Hello world", "2021", "Action", "Brian","brian, Kidiga", "Action movie on a beautiful island by naruto uzumaki uchiha", "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/muviapp%2F0_3.jpeg?alt=media&token=18c78b3d-1832-4324-90b6-bf10673d7b65", listOf()),
        Movie("11", "Hello world", "2021", "Action", "Brian","brian, Kidiga", "Action movie on a beautiful island by naruto uzumaki uchiha", "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/muviapp%2F0_4.png?alt=media&token=cf1b981f-8078-4247-9ad5-4a9f65df5dad", listOf())
    )
}
