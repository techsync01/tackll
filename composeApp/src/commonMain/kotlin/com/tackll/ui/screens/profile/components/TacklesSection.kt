package com.tackll.ui.screens.profile.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tackll.ui.screens.profile.components.TackleListItem
import com.tackll.ui.screens.profile.components.TackleTabs
import com.tackll.ui.screens.profile.model.ProfileViewModel

@Composable
fun TacklesSection(vm: ProfileViewModel) {
    val tackles = vm.filteredTackles

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 40.dp)
    ) {
        // Header Tabs
        TackleTabs(vm)

        Spacer(Modifier.height(8.dp))

        if (tackles.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No Tackles Found",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            // Just render items (no scrolling)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                tackles.forEach { t ->
                    TackleListItem(item = t)
                }
            }
        }
    }
}
