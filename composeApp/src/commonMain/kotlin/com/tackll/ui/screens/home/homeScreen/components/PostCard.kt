package com.tackll.ui.screens.home.homeScreen.components



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import coil3.compose.AsyncImage
import com.tackll.ui.screens.home.homeScreen.modal.Post
import org.jetbrains.compose.resources.painterResource
import tackll.composeapp.generated.resources.Res
import tackll.composeapp.generated.resources.avtar

@Composable
fun PostCard(post: Post) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
//            Box(
//                modifier = Modifier
//                    .size(36.dp)
//                    .clip(RoundedCornerShape(50))
//                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.3f))
//            )
            AsyncImage(
                model = post.profilePicture,
                contentDescription = post.caption,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(Res.drawable.avtar), // while loading
                error = painterResource(Res.drawable.avtar),       // on fail or empty
                fallback = painterResource(Res.drawable.avtar),
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    )
            )
            Spacer(Modifier.width(8.dp))
            Text(post.userName, fontWeight = FontWeight.Bold)
        }

        Spacer(Modifier.height(8.dp))
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(180.dp)
//                .clip(RoundedCornerShape(12.dp))
//                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
//        )
//        )
        AsyncImage(
            model = post.image,
            contentDescription = post.caption,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
        )

        Spacer(Modifier.height(8.dp))
        Text(post.caption, style = MaterialTheme.typography.bodyMedium)
        Text(
            "${post.timeAgo} Weeks ago | ${post.proViews} ProViews | ${post.views} views",
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )
    }
}
