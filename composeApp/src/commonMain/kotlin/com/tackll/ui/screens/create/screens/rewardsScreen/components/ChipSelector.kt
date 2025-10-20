package com.tackll.ui.screens.create.screens.rewardsScreen.components


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tackll.ui.screens.create.screens.parametersScreen.components.InfoLabel

@Composable
fun ChipSelector(
    label: String,
    items: List<String>,
    selectedItem: String?,
    otherText: String,
    onSelect: (String?) -> Unit,
    onOtherChange: (String) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        InfoLabel(label)

        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items.forEach { item ->
                FilterChip(
                    selected = selectedItem == item,
                    onClick = {
                        onSelect(if (selectedItem == item) null else item)
                        onOtherChange("")
                    },
                    label = { Text(item) },
                    shape = MaterialTheme.shapes.large,
//                    border = FilterChipDefaults.filterChipBorder(
//                        borderColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
//                    ),
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                        selectedLabelColor = MaterialTheme.colorScheme.onPrimary,
                        containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.2f),
                        labelColor = MaterialTheme.colorScheme.onSurface
                    )
                )
            }
        }

        OutlinedTextField(
            value = otherText,
            onValueChange = {
                onOtherChange(it)
                if (it.isNotEmpty()) onSelect(null)
            },
            placeholder = { Text("Other") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
    }
}
