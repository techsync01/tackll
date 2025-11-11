//
//package com.tackll.navigation
//
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.foundation.layout.*
//import androidx.compose.ui.Modifier
////import com.tackll.ui.screens.ProfileScreen
//import com.tackll.ui.screens.create.createParent.screen.CreateScreen
//import com.tackll.ui.screens.explore.screen.ExploreScreen
//import com.tackll.ui.screens.explore.screen.ExploreSeeMoreScreen
//
//import com.tackll.ui.screens.flicks.FlicksScreen
//import com.tackll.ui.screens.home.homeScreen.screens.HomeScreen
//import com.tackll.ui.screens.home.homeScreen.components.FloatingFilterButton
//import com.tackll.ui.screens.profile.screen.ProfileScreen
//
//@Composable
//fun NavGraph(
//    modifier: Modifier = Modifier,
//    darkTheme: Boolean,
//    onThemeToggle: () -> Unit
//) {
//    // Track bottom navigation selection
//    var selectedItem by remember { mutableStateOf<BottomNavItem>(BottomNavItem.Home) }
//
//    // Handle internal Explore navigation (Explore → SeeMore)
//    var currentExplorePage by remember { mutableStateOf("main") }
//    var currentSeeMoreKey by remember { mutableStateOf<String?>(null) }
//
//    Scaffold(
//        bottomBar = {
//            CurvedBottomBar(
//                selectedItem = selectedItem,
//                onItemSelected = {
//                    selectedItem = it
//                    // Reset explore subpage when leaving Explore
//                    if (it != BottomNavItem.Explore) {
//                        currentExplorePage = "main"
//                        currentSeeMoreKey = null
//                    }
//                },
//                darkTheme = darkTheme
//            )
//        },
//        floatingActionButton = {
//            if (selectedItem == BottomNavItem.Home) {
//                FloatingFilterButton()
//            }
//        }
//    ) { innerPadding ->
//        Box(modifier = Modifier
//            .padding(innerPadding)
//            .fillMaxSize()
//        ) {
//            when (selectedItem) {
//                BottomNavItem.Home -> HomeScreen(onThemeToggle = onThemeToggle)
//                BottomNavItem.Flicks -> FlicksScreen()
//                BottomNavItem.Create -> CreateScreen()
//                BottomNavItem.Profile -> ProfileScreen()
//                BottomNavItem.Explore -> {
//                    // Navigation within Explore (main → seeMore)
//                    when (currentExplorePage) {
//                        "main" -> ExploreScreen(
//                            onSeeMore = { sectionKey ->
//                                currentSeeMoreKey = sectionKey
//                                currentExplorePage = "seeMore"
//                            }
//                        )
//                        "seeMore" -> ExploreSeeMoreScreen(
//                            sectionKey = currentSeeMoreKey ?: "",
//                            onBack = { currentExplorePage = "main" }
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
//




package com.tackll.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.tackll.ui.screens.create.createParent.screen.CreateScreen
import com.tackll.ui.screens.explore.screen.ExploreScreen
import com.tackll.ui.screens.explore.screen.ExploreSeeMoreScreen
import com.tackll.ui.screens.flicks.FlicksScreen
import com.tackll.ui.screens.home.homeScreen.screens.HomeScreen
import com.tackll.ui.screens.home.homeScreen.components.FloatingFilterButton
import com.tackll.ui.screens.profile.screen.ProfileScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    darkTheme: Boolean,
    onThemeToggle: () -> Unit
) {
    val navController = rememberNavController()
    val bottomItems = listOf(
        BottomNavItem.Home,
        BottomNavItem.Flicks,
        BottomNavItem.Create,
        BottomNavItem.Explore,
        BottomNavItem.Profile
    )

    // Track current route for bottom bar highlight
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            CurvedBottomBar(
                selectedItem = bottomItems.firstOrNull { it.route == currentRoute } ?: BottomNavItem.Home,
                onItemSelected = { item ->
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                darkTheme = darkTheme
            )
        },
        floatingActionButton = {
            if (currentRoute == BottomNavItem.Home.route) {
                FloatingFilterButton()
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            AppNavHost(
                navController = navController,
                onThemeToggle = onThemeToggle
            )
        }
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    onThemeToggle: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ) {
        composable(BottomNavItem.Home.route) {
            HomeScreen(onThemeToggle = onThemeToggle)
        }
        composable(BottomNavItem.Flicks.route) {
            FlicksScreen()
        }
        composable(BottomNavItem.Create.route) {
            CreateScreen()
        }
        composable(BottomNavItem.Profile.route) {
            ProfileScreen()
        }
        composable(BottomNavItem.Explore.route) {
            ExploreNavigation(navController)
        }
    }
}

/**
 * Separate navigation graph for Explore section (nested navigation)
 */
@Composable
fun ExploreNavigation(navController: NavHostController) {
    var currentExplorePage by remember { mutableStateOf("main") }
    var currentSeeMoreKey by remember { mutableStateOf<String?>(null) }

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
