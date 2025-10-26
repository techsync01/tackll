package com.tackll.ui.screens.profile.screen


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tackll.ui.screens.profile.components.*
import com.tackll.ui.screens.profile.model.DummyData
import com.tackll.ui.screens.profile.model.ProfileViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileScreen(viewModel: ProfileViewModel = ProfileViewModel()) {
    val vm = viewModel

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(bottom = 100.dp)
    ) {
        item { ProfileTopBar() }

        item {
            ProfileHeader(
                user = vm.user,
                isBioExpanded = vm.isBioExpanded,
                onToggleBio = { vm.toggleBio() }
            )
        }

        item {
            Spacer(Modifier.height(12.dp))
            ProgressStepper(steps = listOf("Lorem", "Lorem", "Lorem", "Lorem", "Lorem"), activeIndex = 1)
            Spacer(Modifier.height(8.dp))
        }

        stickyHeader {
            Surface(color = MaterialTheme.colorScheme.background) {
                ProfileTabs(
                    activeIndex = vm.activeTabIndex,
                    onTabSelected = { vm.activeTabIndex = it },
                    onToggleGrid =  {vm.toggleGrid() },
                    isGrid = vm.showGrid,
//                    months = listOf("January", "February", "March", "April"),
                   months= DummyData.months,
                    selectedMonth = vm.selectedMonth,
                    onMonthSelect = { vm.selectedMonth = it }
                )

            }
        }

        //  Month dropdown - visible in all tab

        //  Filtered POSTS
        if (vm.activeTabIndex == 0) {
            val posts = vm.filteredPosts
            if (posts.isEmpty()) {
                item { EmptyMonthPlaceholder() }
            } else {
                items(posts) { item ->
//                    PostListItem(item = item, modifier = Modifier.padding(horizontal = 16.dp))
                    PostListItem(item = item, isGridMode = vm.showGrid)
                }
            }
        }

        //  Filtered FLICKS
        if (vm.activeTabIndex == 1) {
            val reels = vm.filteredReels
            if (reels.isEmpty()) {
                item { EmptyMonthPlaceholder() }
            } else {
                val rows = reels.chunked(3)
                items(rows) { row ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp),
                        horizontalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        // each item gets equal weight so each row fills width with 3 columns
                        for (colIndex in 0 until 3) {
                            val cellItem = row.getOrNull(colIndex)
                            if (cellItem != null) {
                                Box(modifier = Modifier.weight(1f)) {
                                    ReelGridItem(item = cellItem, modifier = Modifier.fillMaxSize())
                                }
                            } else {
                                // filler to keep spacing consistent when last row has < 3 items
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }

            }
        }

        //  Filtered TACKLES
        if (vm.activeTabIndex == 2) {
            item {
                TacklesSection(vm)
            }
        }
    }
}

@Composable
private fun EmptyMonthPlaceholder() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 80.dp),
        contentAlignment = Alignment.Center
    ) {
        Text("No content for this month", color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}




