package com.tackll.ui.screens.flicks.flicksScreen.components

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
//import com.tackll.ui.screens.flicks.components.ActionColumn
import com.tackll.ui.screens.flicks.flicksScreen.modal.Flick
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import com.tackll.common.video.VideoPlayer
import com.tackll.ui.screens.flicks.comment.commentScreen.CommentBottomSheet
import com.tackll.ui.screens.flicks.shareScreen.screen.ShareBottomSheet

//import com.tackll.ui.screens.flicks.components.ActionColumn


@Composable
fun FlickItem(flick: Flick) {
    var expanded by remember { mutableStateOf(false) }
    var isLiked by remember { mutableStateOf(flick.isLiked) }
    var isParticipating by remember { mutableStateOf(flick.isParticipating) }
    var likes by remember { mutableStateOf(flick.likes) }
    var participants by remember { mutableStateOf(flick.participants) }

    var showComments by remember { mutableStateOf(false) }
    var showShare by remember { mutableStateOf(false) }


    Box(modifier = Modifier.fillMaxSize()) {
        // Video placeholder
//        Image(
//            painter = rememberAsyncImagePainter(flick.videoUrl),
//            contentDescription = null,
//            modifier = Modifier.fillMaxSize()
//        )
        // ✅ Replace Image with actual Video Player
        VideoPlayer(
            url = flick.videoUrl,
            modifier = Modifier.fillMaxSize(),
            autoPlay = true, // autoplay like reels
            loop = true,
            showProgressAlways=true,
            thumbnail=flick.thumbnailUrl,
        )

        // Right-side actions
//        ActionColumn(
//            likes = flick.likes,
//            comments = flick.comments,
//            shares = flick.shares,
//            participants = flick.participants
//        )
        ActionColumn(
            likes = likes,
            comments = flick.comments,
            shares = flick.shares,
            participants = participants,
            isLiked = isLiked,
            isParticipating = isParticipating,
            onLikeClick = {
                isLiked = !isLiked
                likes += if (isLiked) 1 else -1
            },
            onCommentClick = { showComments = true },
            onShareClick = { showShare = true },
            onParticipantClick = {
                isParticipating = !isParticipating
                participants += if (isParticipating) 1 else -1
            },
            onMoreClick = { showShare = true }
        )

        if (showComments) {
            CommentBottomSheet(
                comments = flick.commentList,
                onDismiss = { showComments = false }
            )
        }

        if (showShare) {
            ShareBottomSheet(onDismiss = { showShare = false })
        }

        // Bottom user info + description
//        Column(
//            modifier = Modifier
//                .align(if (expanded) Alignment.TopStart else Alignment.BottomStart)
//                .padding(16.dp)
//                .then(
//                    if (expanded) Modifier
//                        .fillMaxHeight()
//                        .verticalScroll(rememberScrollState())
//                    else Modifier
//                )
//        ) {
//            UserInfo(userName = flick.userName, avatarUrl = flick.userAvatar)
//            ExpandableDescription(
//                text = flick.description,
//                expanded = expanded,
//                onToggle = { expanded = !expanded }
//            )
//            if (!expanded) {
//                Text(text = "${flick.views} views", color = Color.White.copy(alpha = 0.7f))
//            }
//        }
        // Bottom user info + description
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 16.dp, end = 16.dp, bottom = 35.dp) // bottom padding for nav bar
                .then(
                    if (expanded) Modifier
                        .wrapContentHeight()
                        .verticalScroll(rememberScrollState())
                    else Modifier
                )
        ) {
            UserInfo(userName = flick.userName, avatarUrl = flick.userAvatar)
            ExpandableDescription(
                text = flick.description,
                expanded = expanded,
                onToggle = { expanded = !expanded }
            )
            Text(text = "${flick.views} views", color = Color.White.copy(alpha = 0.7f))
        }

        // Progress bar
//        VideoProgressBar(modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 35.dp))
    }
}