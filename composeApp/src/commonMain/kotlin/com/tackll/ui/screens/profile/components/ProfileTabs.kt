
package com.tackll.ui.screens.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tackll.ui.screens.profile.model.getCurrentMonth

//import com.tackll.utils.getCurrentMonth

@Composable
fun ProfileTabs(
    activeIndex: Int,
    onTabSelected: (Int) -> Unit,
    onToggleGrid: () -> Unit,
    isGrid: Boolean,
    months: List<String>,
    selectedMonth: String,
    onMonthSelect: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    // Automatically reset month when switching tabs
    val currentMonth = remember { getCurrentMonth() }

    LaunchedEffect(activeIndex) {
        onMonthSelect(currentMonth)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.05f))
    ) {
        // ===== Tabs Row =====
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TabIcon(
                icon = Icons.Default.GridView,
                isActive = activeIndex == 0,
                onClick = { onTabSelected(0) }
            )
            TabIcon(
                icon = Icons.Default.Bolt,
                isActive = activeIndex == 1,
                onClick = { onTabSelected(1) }
            )
            TabIcon(
                icon = Icons.Default.Checklist,
                isActive = activeIndex == 2,
                onClick = { onTabSelected(2) }
            )
        }

        // ===== Active Indicator Line =====
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .padding(horizontal = 24.dp)
                .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.15f))
        ) {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(2.dp)
                    .align(
                        when (activeIndex) {
                            0 -> Alignment.CenterStart
                            1 -> Alignment.Center
                            else -> Alignment.CenterEnd
                        }
                    )
                    .background(MaterialTheme.colorScheme.primary)
            )
        }

        Spacer(Modifier.height(6.dp))

        // ===== Month Dropdown + Toggle Row =====
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Month Dropdown
            MonthDropdownCompact(
                months = months,
                selected = selectedMonth,
                onSelect = onMonthSelect
            )

            if (activeIndex == 0) {
                // Toggle Button (Grid/List)
                Surface(
                    modifier = Modifier
                        .size(38.dp)
                        .shadow(6.dp, CircleShape),
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    shape = CircleShape
                ) {
                    IconButton(onClick = onToggleGrid) {
                        Icon(
                            imageVector = if (isGrid) Icons.Default.List else Icons.Default.GridView,
                            contentDescription = "Toggle layout",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TabIcon(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    isActive: Boolean,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = if (isActive)
                MaterialTheme.colorScheme.primary
            else
                MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.size(26.dp)
        )
    }
}

@Composable
fun MonthDropdownCompact(
    months: List<String>,
    selected: String,
    onSelect: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        Row(
            modifier = Modifier
                .clickable { expanded = true }
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = selected,
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 16.sp)
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(start = 4.dp)
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            shape = RoundedCornerShape(10.dp)
        ) {
            months.forEach { month ->
                DropdownMenuItem(
                    text = { Text(month) },
                    onClick = {
                        onSelect(month)
                        expanded = false
                    }
                )
            }
        }
    }
}
