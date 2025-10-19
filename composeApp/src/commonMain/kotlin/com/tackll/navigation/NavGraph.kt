package com.tackll.navigation


import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import com.tackll.ui.screens.*
import com.tackll.ui.screens.flicks.FlicksScreen
import com.tackll.ui.screens.home.homeScreen.screens.HomeScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    darkTheme: Boolean,
    onThemeToggle: () -> Unit
) {
//    var selectedItem by remember { mutableStateOf(BottomNavItem.Home) }
    var selectedItem by remember { mutableStateOf<BottomNavItem>(BottomNavItem.Home) }
    Scaffold(
        bottomBar = {
            CurvedBottomBar(
                selectedItem = selectedItem,
                onItemSelected = { selectedItem = it },
                darkTheme = darkTheme
            )
        },
        floatingActionButton = {
            if (selectedItem == BottomNavItem.Home) {
                com.tackll.ui.screens.home.homeScreen.components.FloatingFilterButton()
            }
        },

    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedItem) {
                BottomNavItem.Home -> HomeScreen(onThemeToggle = onThemeToggle)
                BottomNavItem.Flicks -> FlicksScreen()
                BottomNavItem.Create -> CreateScreen()
                BottomNavItem.Explore -> ExploreScreen()
                BottomNavItem.Profile -> ProfileScreen()
            }
        }
    }
}




