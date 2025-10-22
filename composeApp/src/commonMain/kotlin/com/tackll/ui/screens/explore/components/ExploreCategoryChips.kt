package com.tackll.ui.screens.explore.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExploreCategoryChips(
    categories: List<String>,
    selected: String,
    onSelect: (String) -> Unit
) {
    val iconMap = mapOf(
        "All" to Icons.Default.ViewModule,
        "Fitness" to Icons.Default.FitnessCenter,
        "Cooking" to Icons.Default.Restaurant,
        "Coding" to Icons.Default.Code,
        "Driving" to Icons.Default.DirectionsCar,
        "Hiking" to Icons.Default.Hiking,
        "Sports" to Icons.Default.SportsSoccer
    )

//    val isDark = !MaterialTheme.colorScheme.isLight
    val isDark = MaterialTheme.colorScheme.background.luminance() < 0.5
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(categories) { category ->
            val isSelected = category == selected

            val iconBackgroundBrush = if (isSelected) {
                Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.6f)
                    )
                )
            } else {
                Brush.linearGradient(
                    if (isDark)
                        listOf(Color(0xFF1C2A4A), Color(0xFF1C2A4A))
                    else
                        listOf(Color(0xFFE8EAF6), Color(0xFFF5F5F5))
                )
            }

            val textChipBrush = if (isSelected) {
                Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.85f),
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.65f)
                    )
                )
            } else {
                Brush.linearGradient(
                    if (isDark)
                        listOf(Color(0xFF0D1A35), Color(0xFF0D1A35))
                    else
                        listOf(Color(0xFFE8EAF6), Color(0xFFF5F5F5))
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .width(80.dp)
                    .clickable { onSelect(category) }
            ) {
                // Icon container
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(
                            brush = iconBackgroundBrush,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .shadow(
                            elevation = if (isSelected) 6.dp else 0.dp,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = iconMap[category] ?: Icons.Default.ViewModule,
                        contentDescription = category,
                        tint = if (isSelected)
                            MaterialTheme.colorScheme.onPrimary
                        else
                            MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(28.dp)
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                // Text chip below
                Box(
                    modifier = Modifier
                        .background(
                            brush = textChipBrush,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = category,
                        color = if (isSelected)
                            MaterialTheme.colorScheme.onPrimary
                        else
                            MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontSize = 13.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                        )
                    )
                }
            }
        }
    }
}







