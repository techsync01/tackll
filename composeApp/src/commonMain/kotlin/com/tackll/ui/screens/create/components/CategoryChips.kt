package com.tackll.ui.screens.create.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CategoryChips(
    categories: List<String>,
    selected: String?,
    otherText: String,
    onCategorySelect: (String?) -> Unit,
    onOtherChange: (String) -> Unit
) {
    // Hoist the color values out of the non-composable scopes
    val onSurfaceColor = MaterialTheme.colorScheme.onSurface
    val primaryColor = MaterialTheme.colorScheme.primary
    val onPrimaryColor = MaterialTheme.colorScheme.onPrimary

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            categories.forEach { cat ->
                FilterChip(
                    selected = selected == cat,
                    onClick = {
                        // Selecting a chip clears the 'Other' input
                        onCategorySelect(if (selected == cat) null else cat)
                        onOtherChange("")
                    },
                    label = { Text(cat) },
                    shape = MaterialTheme.shapes.large,
                    border = FilterChipDefaults.filterChipBorder(
                        enabled = true,
                        selected = selected == cat,
                        borderColor = primaryColor.copy(alpha = 0.5f)
                    ),
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = primaryColor,
                        selectedLabelColor = onPrimaryColor,
                        containerColor = Color.Transparent,
                        labelColor = onSurfaceColor
                    )
                )
            }

            // --- Inline "Other" input ---
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 4.dp)
            ) {
                Text(
                    text = "Other",
                    color = onSurfaceColor,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Underlined TextField-like input
                BasicTextField(
                    value = otherText,
                    onValueChange = {
                        onOtherChange(it)
                        // Typing in 'Other' clears chip selection
                        if (it.isNotEmpty()) onCategorySelect(null)
                    },
                    singleLine = true,

                    textStyle = LocalTextStyle.current.copy(
                        color = onSurfaceColor
                    ),
                    modifier = Modifier
                        .width(100.dp)
                        .drawBehind {
                            // Draw underline
                            val strokeWidth = 1.dp.toPx()
                            drawLine(

                                color = onSurfaceColor.copy(alpha = 0.6f),
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                                strokeWidth = strokeWidth
                            )
                        }
                )
            }
        }
    }
}
