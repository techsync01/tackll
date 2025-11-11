package com.tackll.ui.screens.explore.model




private const val IMG1 = "https://picsum.photos/400/200"
private const val IMG2 = "https://picsum.photos/seed/weightlifting2/400/200"
private const val IMG3 = "https://picsum.photos/seed/dumbbells5/400/200"
private const val IMG4 = "https://picsum.photos/seed/benchpress7/400/200"
private const val IMG5 = "https://picsum.photos/seed/fitnesschallenge10/400/200"
private const val IMG6 = "https://picsum.photos/seed/cardio8/400/200"
private const val AVA1 = "https://placehold.co/100x100?text=A1"
private const val AVA2 = "https://placehold.co/100x100?text=A2"
private const val AVA3 = "https://placehold.co/100x100?text=A3"

val topChallenges = listOf(
    ChallengeItem(1, "30-day fitness challenge", IMG1, "Thefitnessclub", AVA1, "500 views", "3 Weeks ago"),
    ChallengeItem(2, "Cooking Challenge", IMG2, "ChefDaily", AVA2, "1K views", "2 Weeks ago"),
    ChallengeItem(3, "Dance Marathon", IMG3, "RhythmHouse", AVA3, "850 views", "1 Week ago")
)

val topCreators = listOf(
    CreatorItem(
        id = 1,
        name = "John Doe",
        avatarUrl = "https://randomuser.me/api/portraits/men/10.jpg",
        category = "Fitness",
        followers = "12.5K",
        totalPosts = 84,
        rating = 4.8,
        bio = "Certified personal trainer sharing fitness tips and routines."
    ),
    CreatorItem(
        id = 2,
        name = "Sarah Lee",
        avatarUrl = "https://randomuser.me/api/portraits/women/21.jpg",
        category = "Cooking",
        followers = "9.2K",
        totalPosts = 67,
        rating = 4.5,
        bio = "Food lover experimenting with healthy recipes and quick meals."
    ),
    CreatorItem(
        id = 3,
        name = "Mike Smith",
        avatarUrl = "https://randomuser.me/api/portraits/men/30.jpg",
        category = "Coding",
        followers = "15.7K",
        totalPosts = 120,
        rating = 4.9,
        bio = "Software developer sharing Kotlin and Compose tutorials."
    ),
    CreatorItem(
        id = 4,
        name = "Nick Doe",
        avatarUrl = "https://randomuser.me/api/portraits/men/10.jpg",
        category = "Fitness",
        followers = "12.5K",
        totalPosts = 84,
        rating = 4.8,
        bio = "Certified personal trainer sharing fitness tips and routines."
    ),
    CreatorItem(
        id = 5,
        name = "Jason Lee",
        avatarUrl = "https://randomuser.me/api/portraits/women/21.jpg",
        category = "Cooking",
        followers = "9.2K",
        totalPosts = 67,
        rating = 4.5,
        bio = "Food lover experimenting with healthy recipes and quick meals."
    ),
    CreatorItem(
        id = 6,
        name = "Bret Smith",
        avatarUrl = "https://randomuser.me/api/portraits/men/30.jpg",
        category = "Coding",
        followers = "15.7K",
        totalPosts = 120,
        rating = 4.9,
        bio = "Software developer sharing Kotlin and Compose tutorials."
    )
)

val blogItems = listOf(
    BlogItem(1, "30-day fitness challenge: Works multiple muscles...30-day fitness challenge: Works multiple muscles...", IMG1, "Thefitnessclub", AVA1, "500 views", "3 Weeks ago"),
    BlogItem(2, "Healthy Cooking Recipes for Busy People", IMG2, "ChefDaily", AVA2, "300 views", "1 Week ago"),
    BlogItem(3, "Top 10 Dance Warmups", IMG3, "RhythmHouse", AVA3, "200 views", "5 Days ago")
)

val trendingItems = listOf(
    ChallengeItem(10, "Trending Dance Clip", IMG4, "TrendCrew", AVA2, "10K views", "2 Days ago"),
    ChallengeItem(11, "Viral Food Hack", IMG2, "ChefDaily", AVA3, "8.2K views", "3 Days ago"),
    ChallengeItem(12, "Quick Home Workout", IMG1, "FitQuick", AVA1, "7K views", "1 Day ago")
)

val forYouItems = listOf(
    ChallengeItem(20, "Personalized For You 1", IMG5, "CreatorA", AVA1, "2K views", "1 Week ago"),
    ChallengeItem(21, "Personalized For You 2", IMG3, "CreatorB", AVA2, "1.2K views", "4 Days ago"),
    ChallengeItem(22, "Personalized For You 3", IMG6, "CreatorC", AVA3, "900 views", "3 Days ago")
)

val recentUploads = listOf(
    ChallengeItem(30, "New Upload 1", IMG6, "Uploader1", AVA2, "120 views", "12 hours ago"),
    ChallengeItem(31, "New Upload 2", IMG5, "Uploader2", AVA3, "230 views", "1 day ago"),
    ChallengeItem(32, "New Upload 3", IMG4, "Uploader3", AVA1, "80 views", "3 days ago")
)







