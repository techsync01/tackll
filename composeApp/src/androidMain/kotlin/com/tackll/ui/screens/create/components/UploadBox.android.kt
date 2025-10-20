package com.tackll.ui.screens.create.components


import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun pickMediaFile(onFilePicked: (String?) -> Unit) {
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            onFilePicked(it.toString())
        } ?: onFilePicked(null)
    }

    // Launch file picker when triggered
    LaunchedEffect(Unit) {
        launcher.launch("image/* video/*")
    }
}
