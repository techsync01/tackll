
package com.tackll.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import com.tackll.ui.screens.ProfileScreen
import com.tackll.ui.screens.create.createParent.screen.CreateScreen
import com.tackll.ui.screens.explore.screen.ExploreScreen
import com.tackll.ui.screens.explore.screen.ExploreSeeMoreScreen

import com.tackll.ui.screens.flicks.FlicksScreen
import com.tackll.ui.screens.home.homeScreen.screens.HomeScreen
import com.tackll.ui.screens.home.homeScreen.components.FloatingFilterButton

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    darkTheme: Boolean,
    onThemeToggle: () -> Unit
) {
    // Track bottom navigation selection
    var selectedItem by remember { mutableStateOf<BottomNavItem>(BottomNavItem.Home) }

    // Handle internal Explore navigation (Explore → SeeMore)
    var currentExplorePage by remember { mutableStateOf("main") }
    var currentSeeMoreKey by remember { mutableStateOf<String?>(null) }

    Scaffold(
        bottomBar = {
            CurvedBottomBar(
                selectedItem = selectedItem,
                onItemSelected = {
                    selectedItem = it
                    // Reset explore subpage when leaving Explore
                    if (it != BottomNavItem.Explore) {
                        currentExplorePage = "main"
                        currentSeeMoreKey = null
                    }
                },
                darkTheme = darkTheme
            )
        },
        floatingActionButton = {
            if (selectedItem == BottomNavItem.Home) {
                FloatingFilterButton()
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
        ) {
            when (selectedItem) {
                BottomNavItem.Home -> HomeScreen(onThemeToggle = onThemeToggle)
                BottomNavItem.Flicks -> FlicksScreen()
                BottomNavItem.Create -> CreateScreen()
                BottomNavItem.Profile -> ProfileScreen()
                BottomNavItem.Explore -> {
                    // Navigation within Explore (main → seeMore)
                    when (currentExplorePage) {
                        "main" -> ExploreScreen(
                            onSeeMore = { sectionKey ->
                                currentSeeMoreKey = sectionKey
                                currentExplorePage = "seeMore"
                            }
                        )
                        "seeMore" -> ExploreSeeMoreScreen(
                            sectionKey = currentSeeMoreKey ?: "",
                            onBack = { currentExplorePage = "main" }
                        )
                    }
                }
            }
        }
    }
}

