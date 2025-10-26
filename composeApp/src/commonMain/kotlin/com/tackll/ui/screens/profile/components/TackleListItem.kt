package com.tackll.ui.screens.profile.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.tackll.ui.screens.profile.model.TackleItem
import com.tackll.ui.screens.profile.model.TackleStatus

@Composable
fun TackleListItem(item: TackleItem, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
//        verticalAlignment = Alignment.CenterVertically
    ) {

        AsyncImage(
            model = item.imageUrl,
            contentDescription = item.title,
            modifier = Modifier
                .size(120.dp)
                .height(150.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant),
            contentScale = ContentScale.Crop
        )


        Spacer(Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                item.title,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(Modifier.height(6.dp))

            // Change based on status
            if (item.status == TackleStatus.IN_TACKLL) {
                Text(
                    "Progress: ${item.progress}/${item.totalDays} days",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.tertiary
                    )
                )
            } else {
                Text(
                    "Achievement: ${item.achievementEmoji ?: ""}",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.primary
                    )
                )
            }
        }
    }
}


