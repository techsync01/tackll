package com.tackll.ui.screens.flicks.flicksScreen.modal

import com.tackll.ui.screens.flicks.comment.modal.Comment

data class Flick(
    val id: String,
    val videoUrl: String,
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
        videoUrl = "https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_1mb.mp4",
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
        videoUrl = "https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_1mb.mp4",
        userName = "FitMaster",
        userAvatar = "https://cdn-icons-png.flaticon.com/512/4140/4140048.png",
        description = "Battle ropes for explosive power and endurance.",
        views = 980,
        likes = 300,
        comments = sampleComments.size,
        shares = 40,
        participants = 0,
        commentList = sampleComments
    )
    // Add more dummy flicks
)


