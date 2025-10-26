package com.tackll.ui.screens.profile.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MonthDropdown(
    months: List<String>,
    selected: String,
    onSelect: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Row(modifier = Modifier
        .clickable { expanded = true }
        .padding(vertical = 8.dp)
    ) {
        Text(text = selected, style = MaterialTheme.typography.titleMedium)
        Icon(Icons.Default.ArrowDropDown, contentDescription = "Select month", modifier = Modifier.padding(start = 6.dp))
    }

    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
        months.forEach { m ->
            DropdownMenuItem(text = { Text(m) }, onClick = { onSelect(m); expanded = false })
        }
    }
}
