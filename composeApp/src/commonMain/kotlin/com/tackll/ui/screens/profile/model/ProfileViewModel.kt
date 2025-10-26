
package com.tackll.ui.screens.profile.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class ProfileViewModel {



    var user by mutableStateOf(DummyData.user)
        private set

//    var selectedMonth by mutableStateOf(DummyData.months.first())
    var selectedMonth by mutableStateOf(getCurrentMonthName())

    var activeTabIndex by mutableStateOf(0) // 0 = Posts, 1 = Flicks, 2 = Tackles
    var showGrid by mutableStateOf(false)
    var isBioExpanded by mutableStateOf(false)
    var showTacklesTab by mutableStateOf("In Tackll")

    private val allPosts = DummyData.posts
    private val allReels = DummyData.reels
    private val allTackles = DummyData.tackles

    // === Filtered content based on selectedMonth ===
    val filteredPosts get() = allPosts.filter { it.month == selectedMonth }
    val filteredReels get() = allReels.filter { it.month == selectedMonth }

    //  Updated filtered tackles (respects sub-tab and month)
    val filteredTackles: List<TackleItem>
        get() {
            val status = if (showTacklesTab == "In Tackll")
                TackleStatus.IN_TACKLL
            else
                TackleStatus.TACKLED
            return allTackles.filter { it.status == status && it.month == selectedMonth }
        }


    // === UI state controls ===
    fun toggleGrid() { showGrid = !showGrid }
    fun setMonth(m: String) { selectedMonth = m }
    fun setTab(i: Int) { activeTabIndex = i }
    fun toggleBio() { isBioExpanded = !isBioExpanded }
    fun setTacklesSubTab(label: String) { showTacklesTab = label }


}

fun getCurrentMonth(): String {
    val now = Clock.System.now()
    val current = now.toLocalDateTime(TimeZone.currentSystemDefault())
    return when (current.monthNumber) {
        1 -> "January"
        2 -> "February"
        3 -> "March"
        4 -> "April"
        5 -> "May"
        6 -> "June"
        7 -> "July"
        8 -> "August"
        9 -> "September"
        10 -> "October"
        11 -> "November"
        else -> "December"
    }
}
