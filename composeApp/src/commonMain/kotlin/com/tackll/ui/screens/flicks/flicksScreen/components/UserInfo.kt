package com.tackll.ui.screens.flicks.flicksScreen.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter

@Composable
fun UserInfo(userName: String, avatarUrl: String) {
    val textColor = MaterialTheme.colorScheme.onBackground

    Row(verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            model = avatarUrl,
            contentDescription = null,
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = userName, color = textColor)
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = {},
            contentPadding = PaddingValues(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Text("Follow")
        }
    }
}


