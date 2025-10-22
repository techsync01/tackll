
package com.tackll.ui.screens.explore.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.tackll.ui.screens.explore.components.*
import com.tackll.ui.screens.explore.model.*

@Composable
fun ExploreSeeMoreScreen(sectionKey: String, onBack: () -> Unit) {
    val title = when (sectionKey) {
        "challenges" -> "Challenges"
        "creators" -> "Creators"
        "blogs" -> "Blogs"
        "trending" -> "Trending"
        "forYou" -> "For You"
        "recent" -> "Recently Uploaded"
        else -> "Results"
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        contentPadding = PaddingValues(bottom = 80.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item { ExploreTopBar() }
        item { ExploreSearchBar() }
        item {
            ExploreCategoryChips(
                listOf("All", "Fitness", "Cooking", "Coding", "Hiking", "Sports"),
                selected = "All",
                onSelect = {}
            )
        }
        item {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = MaterialTheme.colorScheme.onBackground
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        // Section-specific layout
        when (sectionKey) {
            "blogs" -> items(blogItems) { item ->
                ExploreSeeMoreListItem(
                    imageUrl = item.imageUrl,
                    title = item.title,
                    subtitle = "${item.authorName} • ${item.views}",
                    timeAgo = "3 Weeks ago"
                )
            }

            "challenges", "trending", "forYou", "recent" -> {
                val items = when (sectionKey) {
                    "challenges" -> topChallenges
                    "trending" -> trendingItems
                    "forYou" -> forYouItems
                    "recent" -> recentUploads
                    else -> emptyList()
                }

                items(items) { item ->
                    ExploreSeeMoreListItem(
                        imageUrl = item.imageUrl,
                        title = item.title,
                        subtitle = "${item.creatorName} • ${item.views}",
                        timeAgo = "3 Weeks ago"
                    )
                }
            }



            "creators" -> items(topCreators) { creator ->
                CreatorListCard(creator)
            }


            else -> item {
                Text(
                    "No data available",
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
