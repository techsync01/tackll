package com.tackll.ui.screens.flicks.flicksScreen.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun VideoProgressBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(4.dp)
            .background(MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.3f) // Simulate progress
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.onBackground)
        )
    }
}
