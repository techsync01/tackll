package com.tackll.ui.screens.create.screens.parametersScreen.components


import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InfoLabel(label: String) {
    Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = "Info",
            tint = MaterialTheme.colorScheme.secondary,
            modifier = Modifier
                .padding(start = 4.dp)
                .size(18.dp)
        )
    }
}
