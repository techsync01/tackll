//package com.tackll.ui.screens.flicks.flicksScreen.modal
//
//import com.tackll.ui.screens.flicks.comment.modal.Comment
//
//data class Flick(
//    val id: String,
//    val videoUrl: String,
//    val userName: String,
//    val userAvatar: String,
//    val description: String,
//    val views: Int,
//    val likes: Int,
//    val comments: Int,
//    val shares: Int,
//    val participants: Int,
//    var isLiked: Boolean = false,
//    var isParticipating: Boolean = false,
//    val commentList: List<Comment> = emptyList()
//)
//
//val sampleComments = listOf(
//    Comment(
//        id = "c1",
//        userName = "thefitnessclub",
//        userAvatar = "https://cdn-icons-png.flaticon.com/512/4140/4140048.png",
//        text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
//        likes = 383
//    ),
//    Comment(
//        id = "c2",
//        userName = "fitjourney",
//        userAvatar = "https://cdn-icons-png.flaticon.com/512/4140/4140037.png",
//        text = "Amazing transformation workout tips!",
//        likes = 112
//    )
//)
//
//
//
//val flicksDummyList = listOf(
//    Flick(
//        id = "1",
//        videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
//        userName = "Learndance",
//        userAvatar = "https://cdn-icons-png.flaticon.com/512/4140/4140048.png",
//        description = "30-day fitness challenge: Works multiple muscle groups over a month.",
//        views = 1420,
//        likes = 500,
//        comments = sampleComments.size,
//        shares = 80,
//        participants = 0,
//        commentList = sampleComments
//    ),
//    Flick(
//        id = "2",
//        videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
//        userName = "FitMaster",
//        userAvatar = "https://cdn-icons-png.flaticon.com/512/4140/4140048.png",
//        description = "Battle ropes for explosive power and endurance.",
//        views = 980,
//        likes = 300,
//        comments = sampleComments.size,
//        shares = 40,
//        participants = 0,
//        commentList = sampleComments
//    )
//    // Add more dummy flicks
//)
//
//

package com.tackll.ui.screens.flicks.flicksScreen.modal

import com.tackll.ui.screens.flicks.comment.modal.Comment

data class Flick(
    val id: String,
    val videoUrl: String,
    val thumbnailUrl: String,
    val userName: String,
    val userAvatar: String,
    val description: String,
    val views: Int,
    val likes: Int,
    val comments: Int,
    val shares: Int,
    val participants: Int,
    var isLiked: Boolean = false,
    var isParticipating: Boolean = false,
    val commentList: List<Comment> = emptyList()
)

val sampleComments = listOf(
    Comment(
        id = "c1",
        userName = "thefitnessclub",
        userAvatar = "https://cdn-icons-png.flaticon.com/512/4140/4140048.png",
        text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        likes = 383
    ),
    Comment(
        id = "c2",
        userName = "fitjourney",
        userAvatar = "https://cdn-icons-png.flaticon.com/512/4140/4140037.png",
        text = "Amazing transformation workout tips!",
        likes = 112
    )
)

val flicksDummyList = listOf(
    Flick(
        id = "1",
        videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
        thumbnailUrl = "https://picsum.photos/seed/gym_thumbnail1/400/200",
        userName = "Learndance",
        userAvatar = "https://cdn-icons-png.flaticon.com/512/4140/4140048.png",
        description = "30-day fitness challenge: Works multiple muscle groups over a month.",
        views = 1420,
        likes = 500,
        comments = sampleComments.size,
        shares = 80,
        participants = 0,
        commentList = sampleComments
    ),
    Flick(
        id = "2",
        videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
        thumbnailUrl = "https://picsum.photos/seed/gym_thumbnail2/400/200",
        userName = "FitMaster",
        userAvatar = "https://cdn-icons-png.flaticon.com/512/4140/4140048.png",
        description = "Battle ropes for explosive power and endurance.",
        views = 980,
        likes = 300,
        comments = sampleComments.size,
        shares = 40,
        participants = 0,
        commentList = sampleComments
    ),
    Flick(
        id = "3",
        videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4",
        thumbnailUrl = "https://picsum.photos/seed/gym_thumbnail3/400/200",
        userName = "StrongLife",
        userAvatar = "https://cdn-icons-png.flaticon.com/512/4140/4140048.png",
        description = "Leg day madness! Squats, lunges, and strength in every rep.",
        views = 2100,
        likes = 880,
        comments = sampleComments.size,
        shares = 120,
        participants = 0,
        commentList = sampleComments
    ),
    Flick(
        id = "4",
        videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4",
        thumbnailUrl = "https://picsum.photos/seed/gym_thumbnail4/400/200",
        userName = "BeastMode",
        userAvatar = "https://cdn-icons-png.flaticon.com/512/4140/4140048.png",
        description = "Push-up challenge! How many can you do in one go?",
        views = 1650,
        likes = 420,
        comments = sampleComments.size,
        shares = 55,
        participants = 0,
        commentList = sampleComments
    )
)

