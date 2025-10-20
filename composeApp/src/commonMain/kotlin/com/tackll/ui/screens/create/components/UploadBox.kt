

package com.tackll.ui.screens.create.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.tackll.ui.screens.create.model.CreateViewModel

// --- EXPECT declaration for file picking ---
@Composable
expect fun pickMediaFile(onFilePicked: (String?) -> Unit)

// --- Shared UploadBox UI ---
@Composable
fun UploadBox(viewModel: CreateViewModel) {
    val uploadPath by remember { derivedStateOf { viewModel.uploadPath } }
    var showFilePicker by remember { mutableStateOf(false) } // 1. State to control picker

    if (showFilePicker) { // 2. Call the composable from a composable context
        pickMediaFile { path ->
            viewModel.uploadPath = path
            showFilePicker = false // Hide picker after selection
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clickable { showFilePicker = true }, // 3. Trigger the state change on click
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.1f)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            if (uploadPath.isNullOrEmpty()) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Upload",
                    tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                    modifier = Modifier.size(40.dp)
                )
            } else {
                if (uploadPath!!.endsWith(".jpg") || uploadPath!!.endsWith(".png") || uploadPath!!.endsWith(".jpeg")) {
                    AsyncImage(
                        model = uploadPath,
                        contentDescription = "Preview",
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black.copy(alpha = 0.2f))
                            .padding(8.dp),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Text(
                        text = uploadPath!!.substringAfterLast("/"),
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
