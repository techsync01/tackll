//package com.tackll.ui.screens.flicks.components
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Comment
//import androidx.compose.material.icons.filled.Favorite
//import androidx.compose.material.icons.filled.Group
//import androidx.compose.material.icons.filled.MoreVert
//import androidx.compose.material.icons.filled.Share
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun ActionColumn(likes: Int, comments: Int, shares: Int, participants: Int) {
//    val iconColor = MaterialTheme.colorScheme.onBackground
//
//    Box(modifier = Modifier.fillMaxSize()) {
//        Column(
//            modifier = Modifier
//                .align(Alignment.CenterEnd)
//                .padding(end = 0.dp),
//            verticalArrangement = Arrangement.spacedBy(10.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            IconButton(onClick = {}) {
//                Icon(
//                    Icons.Default.Favorite,
//                    contentDescription = null,
//                    tint = iconColor
//                )
//            }
//            Text("likes", color = iconColor)
//
//            IconButton(onClick = {}) {
//                Icon(
//                    Icons.Default.Comment,
//                    contentDescription = null,
//                    tint = iconColor
//                )
//            }
//            Text("comments", color = iconColor)
//
//            IconButton(onClick = {}) {
//                Icon(
//                    Icons.Default.Share,
//                    contentDescription = null,
//                    tint = iconColor
//                )
//            }
//            Text("share", color = iconColor)
//
//            IconButton(onClick = {}) {
//                Icon(
//                    Icons.Default.Group,
//                    contentDescription = null,
//                    tint = iconColor
//                )
//            }
//            Text("participants", color = iconColor)
//
//            IconButton(onClick = {}) {
//                Icon(
//                    Icons.Default.MoreVert,
//                    contentDescription = null,
//                    tint = iconColor
//                )
//            }
//        }
//    }
//}
//


package com.tackll.ui.screens.flicks.flicksScreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Group
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ActionColumn(
    likes: Int,
    comments: Int,
    shares: Int,
    participants: Int,
    isLiked: Boolean,
    isParticipating: Boolean,
    onLikeClick: () -> Unit,
    onCommentClick: () -> Unit,
    onShareClick: () -> Unit,
    onParticipantClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    val iconColor = MaterialTheme.colorScheme.onBackground
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .wrapContentWidth()
                .padding(end = 8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick = onLikeClick) {
                Icon(
                    imageVector = if (isLiked) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription = "Like",
                    tint = if (isLiked) MaterialTheme.colorScheme.primary else iconColor
                )
            }
            Text("$likes", color = iconColor)

            IconButton(onClick = onCommentClick) {
                Icon(Icons.Filled.Comment, contentDescription = "Comments", tint = iconColor)
            }
            Text("$comments", color = iconColor)

            IconButton(onClick = onShareClick) {
                Icon(Icons.Filled.Share, contentDescription = "Share", tint = iconColor)
            }
            Text("$shares", color = iconColor)

            IconButton(onClick = onParticipantClick) {
                Icon(
                    imageVector = if (isParticipating) Icons.Filled.Group else Icons.Outlined.Group,
                    contentDescription = "Participants",
                    tint = if (isParticipating) MaterialTheme.colorScheme.primary else iconColor
                )
            }
            Text("$participants", color = iconColor)

            IconButton(onClick = onMoreClick) {
                Icon(Icons.Filled.MoreVert, contentDescription = "More", tint = iconColor)
            }
        }
    }
}
