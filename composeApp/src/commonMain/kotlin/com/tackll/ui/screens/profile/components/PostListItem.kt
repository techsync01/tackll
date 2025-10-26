

package com.tackll.ui.screens.profile.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.tackll.ui.screens.profile.model.PostItem

@Composable
fun PostListItem(
    item: PostItem,
    isGridMode: Boolean,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var isEllipsized by remember { mutableStateOf(false) }

    if (isGridMode) {
        // ===== GRID MODE (Full-width card: Image on top) =====
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {

            AsyncImage(
                model = item.imageUrl,
                contentDescription = item.title,
                modifier = Modifier
//                    .size(120.dp)
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = item.title,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = if (expanded) Int.MAX_VALUE else 2,
                overflow = TextOverflow.Ellipsis,
                // The onTextLayout callback is a parameter of the Text composable
                onTextLayout = { result ->
                    // Determine if truncated
                    isEllipsized = result.hasVisualOverflow
                },
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .animateContentSize()
            )

            if (isEllipsized || expanded) {
                Text(
                    text = if (expanded) "See less" else "See more",
                    style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.primary),
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                        .clickable { expanded = !expanded }
                )
            }

            Text(
                text = "${item.views} views",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
    } else {
        // ===== LIST MODE (Row layout: Image on left, text on right) =====
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = item.imageUrl,
                contentDescription = item.title,
                modifier = Modifier
                    .size(120.dp)
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.width(12.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .animateContentSize()
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.bodyLarge,
                    maxLines = if (expanded) Int.MAX_VALUE else 2,
                    overflow = TextOverflow.Ellipsis,
                    // The onTextLayout callback is a parameter of the Text composable
                    onTextLayout = { result ->
                        isEllipsized = result.hasVisualOverflow
                    },
                    modifier = Modifier // Modifier chain is now separate
                )

                if (isEllipsized || expanded) {
                    Text(
                        text = if (expanded) "See less" else "See more",
                        style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.primary),
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .clickable { expanded = !expanded }
                    )
                }

                Text(
                    text = "${item.views} views",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = 6.dp)
                )
            }
        }
    }
}
