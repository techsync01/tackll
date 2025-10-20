package com.tackll.ui.screens.create.components

import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// Add this annotation to opt-in to using experimental Material 3 APIs
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = { Text(text = "Create", style = MaterialTheme.typography.titleLarge) },
        actions = {
            IconButton(onClick = {}) { Icon(Icons.Default.Search, contentDescription = "Search") }
            IconButton(onClick = {}) { Icon(Icons.Default.Notifications, contentDescription = "Notifications") }
            IconButton(onClick = {}) { Icon(Icons.Default.Chat, contentDescription = "Chat") }
        },
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    )
}
