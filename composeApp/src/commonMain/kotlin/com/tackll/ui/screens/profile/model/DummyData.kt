package com.tackll.ui.screens.profile.model


import kotlin.random.Random
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun getCurrentMonthName(): String {
    val current = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    return DummyData.months[current.monthNumber - 1] // monthNumber = 1..12
}

object DummyData {

    val months = listOf(
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    )

    // ---- Current month info ----
    private fun currentMonthIndex(): Int {
        val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        return now.monthNumber - 1 // 0-based
    }

    private val currentMonthIdx = currentMonthIndex()
    private val currentMonth = months[currentMonthIdx]

    private fun randomPastMonth(): String {
        val pastMonths = months.take(currentMonthIdx)
        return if (pastMonths.isNotEmpty()) pastMonths.random(Random) else currentMonth
    }

    // ---- USER PROFILE ----
    val user = UserProfile(
        id = "user_1",
        displayName = "Thefitnessclub",
        avatarUrl = "https://images.unsplash.com/photo-1544005313-94ddf0286df2?w=400&q=80",
        followers = 1100,
        followings = 1000,
        bioLines = listOf(
            "• Certified fitness instructor with 10+ years experience.",
            "• Daily workouts and nutrition plans.",
            "• I love community challenges and progress tracking."
        ),
        badges = listOf("🏅", "🏆")
    )

    // ---- POSTS ----
    val posts: List<PostItem> = buildList {
        // Add 5 guaranteed current-month posts
        repeat(5) { idx ->
            add(
                PostItem(
                    id = "post_current_$idx",
                    title = if (idx % 2 == 0)
                        "Current month post #${idx + 1}: 30-day endurance challenge"
                    else
                        "Healthy habit routine for current month #${idx + 1}",
                    imageUrl = "https://images.unsplash.com/photo-1554284126-aa88f22d8a5b?w=800&q=80",
                    views = 500 + idx * 70,
                    month = currentMonth
                )
            )
        }

        // Add 10 more random posts from past months only
        repeat(100) { idx ->
            add(
                PostItem(
                    id = "post_past_$idx",
                    title = if (idx % 2 == 0)
                        "Past challenge post #${idx + 6}"
                    else
                        "Workout summary from last month",
                    imageUrl = "https://images.unsplash.com/photo-1554284126-aa88f22d8a5b?w=800&q=80",
                    views = 300 + idx * 50,
                    month = randomPastMonth()
                )
            )
        }
    }

    // ---- REELS ----
    val reels: List<ReelItem> = buildList {
        // Add 5 guaranteed current-month reels
        repeat(20) { idx ->
            add(
                ReelItem(
                    id = "reel_current_$idx",
                    imageUrl = "https://images.unsplash.com/photo-1526403224741-9a0b3e4f41f8?w=800&q=80",
                    views = 1500 + idx * 120,
                    month = currentMonth
                )
            )
        }

        // Add 15 random past-month reels
        repeat(150) { idx ->
            add(
                ReelItem(
                    id = "reel_past_$idx",
                    imageUrl = "https://images.unsplash.com/photo-1526403224741-9a0b3e4f41f8?w=800&q=80",
                    views = 900 + idx * 90,
                    month = randomPastMonth()
                )
            )
        }
    }

    // ---- TACKLES ----
    val tackles: List<TackleItem> = buildList {
        // Ensure 5 tackles for the current month
        repeat(5) { idx ->
            add(
                TackleItem(
                    id = "tackle_current_$idx",
                    title = "Challenge for $currentMonth #${idx + 1}",
                    imageUrl = "https://images.unsplash.com/photo-1526403224741-9a0b3e4f41f8?w=800&q=80",
                    progress = 25 + (idx % 5),
                    totalDays = 30,
                    achievementEmoji = if (Random.nextBoolean()) "🏅" else "🏆",
                    month = currentMonth,
                    status = if (Random.nextBoolean())
                        TackleStatus.IN_TACKLL
                    else
                        TackleStatus.TACKLED
                )
            )
        }

        // Remaining random tackles across current + past months only
        repeat(10) { idx ->
            add(
                TackleItem(
                    id = "tackle_$idx",
                    title = "30-day fitness challenge: Works multiple muscles ${idx + 6}",
                    imageUrl = "https://images.unsplash.com/photo-1526403224741-9a0b3e4f41f8?w=800&q=80",
                    progress = 25 + (idx % 5),
                    totalDays = 30,
                    achievementEmoji = if (Random.nextBoolean()) "🏅" else "🏆",
                    month = if (Random.nextBoolean()) currentMonth else randomPastMonth(),
                    status = if (Random.nextBoolean())
                        TackleStatus.IN_TACKLL
                    else
                        TackleStatus.TACKLED
                )
            )
        }
    }
}

