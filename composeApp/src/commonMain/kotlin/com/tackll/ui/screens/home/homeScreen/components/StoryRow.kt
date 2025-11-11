//package com.tackll.ui.screens.home.homeScreen.components
//
//import com.tackll.ui.screens.home.homeScreen.modal.DummyData
//
//
//import androidx.compose.foundation.*
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun StoryRow() {
//    Row(
//        horizontalArrangement = Arrangement.spacedBy(16.dp),
//        modifier = Modifier
//            .fillMaxWidth()
//            .horizontalScroll(rememberScrollState())
//            .padding(12.dp)
//    ) {
//        DummyData.stories.forEach { story ->
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                Box(
//                    contentAlignment = Alignment.BottomEnd,
//                    modifier = Modifier.size(60.dp)
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .size(56.dp)
//                            .clip(CircleShape)
//                            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.2f))
//                    )
//                }
//                Text(story.name, style = MaterialTheme.typography.labelMedium)
//            }
//        }
//    }
//}



package com.tackll.ui.screens.home.homeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.tackll.ui.screens.home.homeScreen.modal.DummyData
import org.jetbrains.compose.resources.painterResource
import tackll.composeapp.generated.resources.Res
import tackll.composeapp.generated.resources.avtar

@Composable
fun StoryRow() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        DummyData.stories.forEach { story ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(IntrinsicSize.Min)
            ) {
                Box(
                    modifier = Modifier.size(64.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {

                    // === Story Image (Circular Avatar) ===
                    AsyncImage(
                        model = story.imageUrl,
                        contentDescription = story.name,
                        contentScale = ContentScale.Crop,
                        placeholder = painterResource(Res.drawable.avtar), // while loading
                        error = painterResource(Res.drawable.avtar),       // on fail or empty
                        fallback = painterResource(Res.drawable.avtar),
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .border(
                                width = 2.dp,
                                color = MaterialTheme.colorScheme.primary,
                                shape = CircleShape
                            )

                    )

                    // === "+" Icon for "Your Story" ===
                    if (story.name == "Your Story") {
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary)
                                .align(Alignment.BottomEnd),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "+",
                                color = MaterialTheme.colorScheme.onPrimary,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }
                }

                Spacer(Modifier.height(6.dp))

                // === Story Name ===
                Text(
                    text = story.name,
                    style = MaterialTheme.typography.labelMedium,
                    maxLines = 1,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}
