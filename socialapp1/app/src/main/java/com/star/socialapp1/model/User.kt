package com.star.socialapp1.model

data class User(
    val username : String,
    val status : Status = Status.Active,
    val description : String,
    val profile_picture : String,//url to profile picture
){

    companion object{

        fun getUsers() : List<User> {
            return listOf(

             User(username = "user1", description = "I am user 1", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F13.jpg?alt=media&token=a41dd82a-f25f-48b4-a832-6375ac9b7dc0"),
             User(username = "user2", description = "I am user 2", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F01.jpg?alt=media&token=e1e4c0b4-dae5-4dcf-9fcf-118ee74c117f"),
             User(username = "user3", description = "I am user 3", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F14.jpg?alt=media&token=b8ae6cf0-d5da-4231-9edf-ddc7231b7ee8"),
             User(username = "user4", description = "I am user 4", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F02.jpeg?alt=media&token=161c7f30-1341-40bb-8d6f-8a442911d18f"),
             User(username = "user5", description = "I am user 5", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F15.webp?alt=media&token=090a678c-8245-4dde-8b99-89232e4c700f"),
             User(username = "user6", description = "I am user 6", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F03.jpg?alt=media&token=bcf5360a-8667-461b-999a-0b3e48f3d028"),
             User(username = "user7", description = "I am user 7", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F16.jpg?alt=media&token=ff705f72-e74b-4e42-b58e-b1714c28b270"),
             User(username = "user8", description = "I am user 8", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F04.jpg?alt=media&token=f987b219-7e27-43fe-b39e-ab0f6704d7f2"),
             User(username = "user9", description = "I am user 9", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F17.png?alt=media&token=421d2197-eb37-45d4-b6de-103461b6e197"),
             User(username = "user10", description = "I am user 10", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F05.jpg?alt=media&token=4bca0091-76b6-4093-8256-087fb5317e52"),
             User(username = "user11", description = "I am user 11", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F18.jpg?alt=media&token=26a1ed5f-dd80-4ca5-8a7d-bea60c390a73"),
             User(username = "user12", description = "I am user 12", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F06.jpg?alt=media&token=5fa09c6f-be32-4732-abcb-17b72c802466"),
             User(username = "user13", description = "I am user 13", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F19.jpg?alt=media&token=9a5f5ff5-eeb3-4704-80ad-f2820bd05e0f"),
             User(username = "user14", description = "I am user 14", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F07.jpg?alt=media&token=82b59cb9-d590-4c70-9b1a-c65cd2e7a4fd"),
             User(username = "user15", description = "I am user 15", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F20.jpeg?alt=media&token=66a6f00c-002c-49cf-b4fe-cfb944556397"),
             User(username = "user16", description = "I am user 16", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F08.jpg?alt=media&token=1df5f89b-0890-407d-8b02-70ab9e95dac4"),
             User(username = "user17", description = "I am user 17", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F21.jpg?alt=media&token=7be0fa7e-1795-4619-83e1-37cd59569f55"),
             User(username = "user18", description = "I am user 18", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F09.jpeg?alt=media&token=2149be71-2e3d-4271-8fe0-04fcd31addfe"),
             User(username = "user19", description = "I am user 19", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F22.jpg?alt=media&token=faa7b12c-aa19-4a5d-abd5-4250d7184e93"),
             User(username = "user20", description = "I am user 20", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F10.jpg?alt=media&token=c19f262d-d431-4753-8fef-8f7db9ce8ad3"),
             User(username = "user21", description = "I am user 21", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F23.jpg?alt=media&token=e3f5a40a-b94c-4241-aec4-520df99f9fbd"),
             User(username = "user22", description = "I am user 22", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F11.webp?alt=media&token=7ff7f63d-46c8-4ea1-a4df-5ef708abbea7"),
             User(username = "user23", description = "I am user 23", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F24.jpeg?alt=media&token=2e47430a-b10e-4621-8d98-b1fb794f286e"),
             User(username = "user24", description = "I am user 24", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F12.jpg?alt=media&token=69cc2885-35e9-4a48-922f-ac28fcb115d1"),
             User(username = "user25", description = "I am user 25", profile_picture = "https://firebasestorage.googleapis.com/v0/b/images-b9c1b.appspot.com/o/socialapp%2F25.webp?alt=media&token=8536996b-acdc-40ef-9e9e-6c6302b48d8a")

            )
        }
    }
}