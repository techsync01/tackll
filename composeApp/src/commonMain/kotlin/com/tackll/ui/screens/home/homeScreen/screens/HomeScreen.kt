//package com.tackll.ui.screens.home.homeScreen.screens
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.LightMode
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import com.tackll.ui.screens.home.homeScreen.components.FlicksSection
//import com.tackll.ui.screens.home.homeScreen.components.PostCard
//import com.tackll.ui.screens.home.homeScreen.components.StoryRow
//import com.tackll.ui.screens.home.homeScreen.modal.DummyData
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HomeScreen(onThemeToggle: () -> Unit) {
//    // We can remove the Scaffold if the TopAppBar is the only thing in it.
//    // The LazyColumn will now be the main layout for the screen.
//    LazyColumn(
//        // Use contentPadding to add space at the top and bottom if needed.
//        // modifier = Modifier.fillMaxSize() // Fills the whole screen
//    ) {
//        // 1. Move the TopAppBar into the LazyColumn as the first item.
//        item {
//            TopAppBar(
//                title = { Text("Tackll") },
//                actions = {
//                    IconButton(onClick = onThemeToggle) {
//                        Icon(Icons.Default.LightMode, contentDescription = "Toggle Theme")
//                    }
//                }
//            )
//        }
//
//        // 2. The rest of your list content follows.
//        item {
//            StoryRow()
//        }
//
//        items(DummyData.posts.size) { index ->
//            PostCard(DummyData.posts[index])
//        }
//
//        item {
//            FlicksSection()
//        }
//    }
//}
//


package com.tackll.ui.screens.home.homeScreen.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tackll.ui.screens.home.homeScreen.components.FlicksSection
import com.tackll.ui.screens.home.homeScreen.components.PostCard
import com.tackll.ui.screens.home.homeScreen.components.StoryRow
import com.tackll.ui.screens.home.homeScreen.modal.DummyData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onThemeToggle: () -> Unit) {
    val posts = DummyData.posts
    val postCount = posts.size

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        // Top App Bar
        item {
            TopAppBar(
                title = { Text("Tackll") },
                actions = {
                    IconButton(onClick = onThemeToggle) {
                        Icon(Icons.Default.LightMode, contentDescription = "Toggle Theme")
                    }
                }
            )
        }

        // Story Row
        item {
            StoryRow()
        }

        if (postCount == 0) {
            // No posts
            item {
                Box(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                    Text("No posts available.")
                }
            }
        } else {
            val flickerInsertIndex = if (postCount >= 3) 3 else postCount

            // Show posts before flicker
            items(flickerInsertIndex) { index ->
                PostCard(posts[index])
            }

            // Show flicker after 1 to 3 posts, if we have at least one post
            if (postCount >= 1) {
                item {
                    FlicksSection()
                }
            }

            // Show remaining posts after flicker (if any)
            if (postCount > flickerInsertIndex) {
                items(postCount - flickerInsertIndex) { index ->
                    PostCard(posts[index + flickerInsertIndex])
                }
            }
        }
    }
}
