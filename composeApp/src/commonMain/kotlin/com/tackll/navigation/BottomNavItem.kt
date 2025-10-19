package com.tackll.navigation


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val title: String, val icon: ImageVector, val route: String) {
    object Home : BottomNavItem("Home", Icons.Default.Home, "home")
    object Flicks : BottomNavItem("Flicks", Icons.Default.Bolt, "flicks")
    object Create : BottomNavItem("Create", Icons.Default.Add, "create")
    object Explore : BottomNavItem("Explore", Icons.Default.Explore, "explore")
    object Profile : BottomNavItem("Profile", Icons.Default.Person, "profile")
}
