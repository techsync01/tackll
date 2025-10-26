
package com.tackll.ui.screens.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.tackll.ui.screens.profile.model.UserProfile

@Composable
fun ProfileHeader(
    user: UserProfile,
    isBioExpanded: Boolean,
    onToggleBio: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.Top
    ) {

        // Left Section - Avatar + Username + Badges
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.weight(0.5f)
        ) {
            Box {
                AsyncImage(
                    model = user.avatarUrl,
                    contentDescription = user.displayName,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .shadow(6.dp, RoundedCornerShape(12.dp))
                )

                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.TopEnd)
                        .offset(x = 6.dp, y = (-6).dp)
                        .background(MaterialTheme.colorScheme.primary, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "✓",
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(Modifier.height(8.dp))

            Text(
                text = user.displayName,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            )

            Spacer(Modifier.height(6.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                user.badges.forEach { badge ->
                    Text(text = badge, fontSize = 22.sp)
                }

                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .background(
                            MaterialTheme.colorScheme.surfaceVariant,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Add badge",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }

        Spacer(Modifier.width(16.dp))

        // Right Section - Followers, Following, Bio
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.weight(0.7f)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(50.dp)) {
                Column(horizontalAlignment = Alignment.Start) {
                    Text(
                        text = "${user.followers / 1000.0}K".replace(".0", ""),
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        "Followers",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    )
                }

                Column(horizontalAlignment = Alignment.Start) {
                    Text(
                        text = "${user.followings / 1000.0}K".replace(".0", ""),
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        "Followings",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    )
                }
            }

            Spacer(Modifier.height(10.dp))

            // Bio Section
            val bioText = user.bioLines.joinToString("\n")
            val displayedBio =
                if (isBioExpanded) bioText else user.bioLines.take(2).joinToString("\n")

            Text(
                text = displayedBio,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 4.dp)
            )

            Text(
                text = if (isBioExpanded) "See less" else "See more",
                style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.primary),
                modifier = Modifier
                    .padding(top = 6.dp)
                    .clickable { onToggleBio() }
            )
        }
    }
}

