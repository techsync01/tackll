package com.tackll.ui.screens.explore.screen

import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import com.tackll.ui.screens.explore.components.*
import com.tackll.ui.screens.explore.model.*

/**
 * ExploreScreen shows every section:
 * - Top 3 Challenges
 * - Top Creators (avatar style)
 * - Blogs
 * - Trending
 * - For You
 * - Recently Uploaded
 *
 * onSeeMore receives a key like "challenges","creators","blogs","trending","forYou","recent"
 */
@Composable
fun ExploreScreen(onSeeMore: (String) -> Unit) {
    var selectedCategory by remember { mutableStateOf("All") }
    val categories = listOf("All", "Fitness", "Cooking", "Coding", "Driving", "Hiking", "Sports")

    LazyColumn(contentPadding = PaddingValues(bottom = 80.dp)) {
        item { ExploreTopBar() }
        item { ExploreSearchBar() }
        item { ExploreCategoryChips(categories, selectedCategory, onSelect = { selectedCategory = it }) }

        // Top 3 Challenges (carousel)
        item {
            ExploreSectionHeader("Top 3 Challenges", onSeeMore = { onSeeMore("challenges") })
            LazyRow(contentPadding = PaddingValues(horizontal = 16.dp), horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(12.dp)) {
                items(topChallenges) { item ->
                    ChallengeCard(item = item)
                }
            }
        }

        // Top Creators (avatar horizontal)
        item {
            ExploreSectionHeader("Top Creators", onSeeMore = { onSeeMore("creators") })
            LazyRow(contentPadding = PaddingValues(horizontal = 16.dp), horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(12.dp)) {
                items(topCreators) { creator ->
                    CreatorAvatarCard(item = creator)
                }
            }
        }

        // Blogs (horizontal image cards)
        item {
            ExploreSectionHeader("Blogs", onSeeMore = { onSeeMore("blogs") })
            LazyRow(contentPadding = PaddingValues(horizontal = 16.dp), horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(12.dp)) {
                items(blogItems) { blog ->
                    BlogCard(item = blog, modifier = androidx.compose.ui.Modifier.width(260.dp))
                }
            }
        }

        // Trending
        item {
            ExploreSectionHeader("Trending", onSeeMore = { onSeeMore("trending") })
            LazyRow(contentPadding = PaddingValues(horizontal = 16.dp), horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(12.dp)) {
                items(trendingItems) { it -> ChallengeCard(item = it) }
            }
        }

        // For You
        item {
            ExploreSectionHeader("For You", onSeeMore = { onSeeMore("forYou") })
            LazyRow(contentPadding = PaddingValues(horizontal = 16.dp), horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(12.dp)) {
                items(forYouItems) { it -> ChallengeCard(item = it) }
            }
        }

        // Recently Uploaded
        item {
            ExploreSectionHeader("Recently Uploaded", onSeeMore = { onSeeMore("recent") })
            LazyRow(contentPadding = PaddingValues(horizontal = 16.dp), horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(12.dp)) {
                items(recentUploads) { it -> ChallengeCard(item = it) }
            }
        }
    }
}

