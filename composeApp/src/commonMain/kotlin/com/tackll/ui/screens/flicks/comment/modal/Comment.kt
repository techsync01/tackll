package com.tackll.ui.screens.flicks.comment.modal


data class Comment(
    val id: String,
    val userName: String,
    val userAvatar: String,
    val text: String,
    var likes: Int = 0,
    var isLiked: Boolean = false
)
