//package com.tackll.ui.screens.home.homeScreen.components
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.lazy.grid.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.unit.dp
//import coil3.compose.AsyncImage
//import com.tackll.ui.screens.home.homeScreen.modal.DummyData
//
//@Composable
//fun FlicksSection() {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 12.dp, vertical = 8.dp)
//    ) {
//        Text(
//            text = "⚡ Flicks",
//            style = MaterialTheme.typography.titleMedium,
//            modifier = Modifier.padding(start = 4.dp, bottom = 8.dp)
//        )
//
//        // Instead of a nested scroll, make grid items expand naturally
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(2),
//            modifier = Modifier
//                .fillMaxWidth()
//                .heightIn(max = 800.dp), // Prevent infinite height issues
//            verticalArrangement = Arrangement.spacedBy(12.dp),
//            horizontalArrangement = Arrangement.spacedBy(12.dp),
//            userScrollEnabled = false // Important: disable inner scroll
//        ) {
//            items(DummyData.flicks) { flick ->
//                Card(
//                    shape = RoundedCornerShape(16.dp),
//                    modifier = Modifier.height(300.dp)
//                ) {
//                    Box(
//                        modifier = Modifier.fillMaxSize(),
//                        contentAlignment = Alignment.BottomStart
//                    ) {
//                        // Show thumbnail image for now (videos need ExoPlayer)
//                        AsyncImage(
//                            model = "https://picsum.photos/seed/${flick.title.hashCode()}/400/300",
//                            contentDescription = flick.title,
//                            contentScale = ContentScale.Crop,
//                            modifier = Modifier.fillMaxSize()
//                        )
//
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .background(
//                                    MaterialTheme.colorScheme.surface.copy(alpha = 0.4f)
//                                )
//                                .padding(8.dp)
//                        ) {
//                            Text(
//                                text = flick.title,
//                                style = MaterialTheme.typography.bodyMedium,
//                                color = MaterialTheme.colorScheme.onSurface
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }
//}


package com.tackll.ui.screens.home.homeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.tackll.common.video.VideoPlayer
import com.tackll.ui.screens.home.homeScreen.modal.DummyData

//@Composable
//fun FlicksSection() {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 12.dp, vertical = 8.dp)
//    ) {
//        Text(
//            text = "⚡ Flicks",
//            style = MaterialTheme.typography.titleMedium,
//            modifier = Modifier.padding(start = 4.dp, bottom = 8.dp)
//        )
//
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(2),
//            modifier = Modifier
//                .fillMaxWidth()
//                .heightIn(max = 800.dp),
//            verticalArrangement = Arrangement.spacedBy(12.dp),
//            horizontalArrangement = Arrangement.spacedBy(12.dp),
//            userScrollEnabled = false
//        ) {
//            items(DummyData.flicks) { flick ->
//                Card(
//                    shape = RoundedCornerShape(16.dp),
//                    modifier = Modifier.height(300.dp)
//                ) {
//                    Box(
//                        modifier = Modifier.fillMaxSize(),
//                        contentAlignment = Alignment.BottomStart
//                    ) {
//                        // ✅ Cross-platform video player (works on Android, iOS, Web, Desktop)
//                        VideoPlayer(
//                            url = flick.videoUrl,
//                            modifier = Modifier.fillMaxSize(),
//                            autoPlay = false,
//                            showProgressAlways = false,
//                            thumbnail =flick.thumbnailUrl,
//
//                        )
//
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.4f))
//                                .padding(8.dp)
//                        ) {
//                            Text(
//                                text = flick.title,
//                                style = MaterialTheme.typography.bodyMedium,
//                                color = MaterialTheme.colorScheme.onSurface
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
@Composable
fun FlicksSection() {
    var activeIndex by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Text(
            text = "⚡ Flicks",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 4.dp, bottom = 8.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 800.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            userScrollEnabled = false
        ) {
            itemsIndexed(DummyData.flicks) { index, flick ->
                Card(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.height(300.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        if (activeIndex == index) {
                            VideoPlayer(
                                url = flick.videoUrl,
                                modifier = Modifier.fillMaxSize(),
                                autoPlay = true,
                                loop = true,
                                showProgressAlways = false,
                                thumbnail = flick.thumbnailUrl
                            )
                        } else {
                            AsyncImage(
                                model = flick.thumbnailUrl,
                                contentDescription = flick.title,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clickable { activeIndex = index }
                            )
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.4f))
                                .padding(8.dp)
                        ) {
                            Text(
                                text = flick.title,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }
        }
    }
}

