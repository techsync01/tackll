

package com.tackll.ui.screens.create.model

import androidx.compose.runtime.*

class CreateViewModel {
    // Step 1
    var title by mutableStateOf("")
    var description by mutableStateOf("")
    var selectedCategory by mutableStateOf<String?>(null)
    var otherCategory by mutableStateOf("")
    var uploadPath by mutableStateOf<String?>(null)

    // Step 2
    var challengeDuration by mutableStateOf("01")
    var challengeDurationType by mutableStateOf("Days")
    var selectedSubmission by mutableStateOf<String?>(null)
    var otherSubmission by mutableStateOf("")
    var selectedCriteria by mutableStateOf<String?>(null)
    var otherCriteria by mutableStateOf("")

    // Step 3 (Rewards)
    var selectedReward by mutableStateOf<String?>(null)
    var otherReward by mutableStateOf("")
    var selectedEngagement by mutableStateOf<String?>(null)
    var otherEngagement by mutableStateOf("")
    var leaderboardEnabled by mutableStateOf<Boolean?>(null)

    fun printSummary() {
        println(
            """
            --- CREATE FORM SUMMARY ---
            Title: $title
            Description: $description
            Category: ${selectedCategory ?: otherCategory}
            Upload Path: $uploadPath
            Duration: $challengeDuration $challengeDurationType
            Submission: ${selectedSubmission ?: otherSubmission}
            Criteria: ${selectedCriteria ?: otherCriteria}
            Reward: ${selectedReward ?: otherReward}
            Engagement: ${selectedEngagement ?: otherEngagement}
            Leaderboard: ${leaderboardEnabled ?: "Not Selected"}
            ----------------------------
            """.trimIndent()
        )
    }
}

// Dummy lists
val categoryList = listOf("Fitness", "Coding", "Dance", "Music", "Travelling", "Hiking", "Singing", "Studying", "Photography", "Actor")
val durationTypes = listOf("Days", "Weeks", "Months")
val submissionTypes = listOf("Photos", "Videos", "Text", "Gif")
val criteriaList = listOf("Open to All", "7+", "16+", "21+")

val rewardList = listOf("Price Money", "Certificate", "Badges")
val engagementList = listOf("Instagram", "Facebook", "LinkedIn", "TikTok")


