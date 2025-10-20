package com.tackll.ui.screens.create.components



import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import java.awt.FileDialog
import java.awt.Frame

@Composable
actual fun pickMediaFile(onFilePicked: (String?) -> Unit) {
    LaunchedEffect(Unit) {
        val dialog = FileDialog(null as Frame?, "Select File", FileDialog.LOAD)
        dialog.isVisible = true
        val file = dialog.file
        val dir = dialog.directory
        if (file != null && dir != null) {
            onFilePicked("$dir$file")
        } else {
            onFilePicked(null)
        }
    }
}
