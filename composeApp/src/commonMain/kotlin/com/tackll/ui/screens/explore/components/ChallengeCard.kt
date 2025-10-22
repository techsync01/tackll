
package com.tackll.ui.screens.explore.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.tackll.ui.screens.explore.model.ChallengeItem

@Composable
fun ChallengeCard(item: ChallengeItem, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    var isTextOverflowed by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .width(260.dp)
            .animateContentSize()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(16.dp)),

        horizontalAlignment = Alignment.Start
    ) {
        // Thumbnail (image or video preview)
        AsyncImage(
            model = item.imageUrl,
            contentDescription = item.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Title with See More / See Less
        if (expanded) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground
                ),
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            Text(
                text = "See less",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier
                    .padding(start = 4.dp, top = 2.dp)
                    .clickable { expanded = false }
            )
        } else {
            Text(
                text = item.title,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .fillMaxWidth(),
                onTextLayout = { result ->
                    isTextOverflowed = result.hasVisualOverflow
                }
            )
            if (isTextOverflowed) {
                Text(
                    text = "See more",
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier
                        .padding(start = 4.dp, top = 2.dp)
                        .clickable { expanded = true }
                )
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        // Creator and views info
        Text(
            text = "${item.creatorName} | ${item.views}",
            style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.onSurfaceVariant
            ),
            modifier = Modifier.padding(horizontal = 4.dp)
        )
    }
}
