package com.tackll.ui.screens.flicks.comment.commentScreen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.tackll.ui.screens.flicks.comment.modal.Comment
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentBottomSheet(
    comments: List<Comment>,
    onDismiss: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
        containerColor = MaterialTheme.colorScheme.surface,
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.95f)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Comments",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Divider(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 8.dp)
            ) {
                items(comments) { comment ->
                    CommentItem(comment)
                    Divider(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f))
                }
            }

            CommentInputBar()
        }
    }
}

@Composable
fun CommentItem(comment: Comment) {
    var liked by remember { mutableStateOf(comment.isLiked) }
    var likeCount by remember { mutableStateOf(comment.likes) }

    Row(
        modifier = Modifier.padding(vertical = 8.dp),
        verticalAlignment = Alignment.Top
    ) {
        AsyncImage(
            model = comment.userAvatar,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(MaterialTheme.shapes.small)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(comment.userName, style = MaterialTheme.typography.bodyMedium)
            Text(comment.text, style = MaterialTheme.typography.bodySmall)
            Text("Reply", color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.labelSmall)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            IconButton(onClick = {
                liked = !liked
                likeCount += if (liked) 1 else -1
            }) {
                Icon(
                    imageVector = if (liked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = null,
                    tint = if (liked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                )
            }
            Text("$likeCount", style = MaterialTheme.typography.labelSmall)
        }
    }
}

@Composable
fun CommentInputBar() {
    var commentText by remember { mutableStateOf(TextFieldValue("")) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = "https://cdn-icons-png.flaticon.com/512/4140/4140048.png",
            contentDescription = null,
            modifier = Modifier
                .size(36.dp)
                .clip(MaterialTheme.shapes.small)
        )
        Spacer(modifier = Modifier.width(8.dp))
        OutlinedTextField(
            value = commentText,
            onValueChange = { commentText = it },
            placeholder = { Text("Comment here") },
            modifier = Modifier.weight(1f),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            )
        )
    }
}
