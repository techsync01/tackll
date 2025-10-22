package com.tackll.ui.screens.explore.model

data class CreatorItem(
    val id: Int,
    val name: String,
    val avatarUrl: String,
    val category: String,
    val followers: String,
    val totalPosts: Int,
    val rating: Double,
    val bio: String
)