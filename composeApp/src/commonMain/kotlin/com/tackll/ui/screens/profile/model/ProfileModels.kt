package com.tackll.ui.screens.profile.model

data class UserProfile(
    val id: String,
    val displayName: String,
    val avatarUrl: String?,
    val followers: Int,
    val followings: Int,
    val bioLines: List<String>,
    val badges: List<String>
)

data class PostItem(
    val id: String,
    val title: String,
    val imageUrl: String?,
    val views: Int,
    val month: String
)

data class ReelItem(
    val id: String,
    val imageUrl: String?,
    val views: Int,
    val month: String
)

data class TackleItem(
    val id: String,
    val title: String,
    val imageUrl: String?,
    val progress: Int,
    val totalDays: Int,
    val achievementEmoji: String?,
    val month: String,
    val status: TackleStatus
)


enum class TackleStatus {
    IN_TACKLL,
    TACKLED
}


