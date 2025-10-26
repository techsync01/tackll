package com.tackll.ui.screens.profile.components


import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileTopBar(
    title: String = "User Id",
    modifier: Modifier = Modifier
) {
    // The top bar is part of the scrolling content; visual style uses background gradient from theme
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.background,
        shadowElevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = title, style = MaterialTheme.typography.headlineSmall)
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Icon(Icons.Default.Search, contentDescription = "Search")
                Icon(Icons.Default.Notifications, contentDescription = "Notifications")
                Icon(Icons.Default.ChatBubbleOutline, contentDescription = "Chat")
            }
        }
    }
}
