

package com.tackll.ui.screens.create.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.type
//import androidx.compose.ui.test.click
import kotlinx.browser.document
//import org.jetbrains.compose.reload.gradle.files
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.url.URL // Import the correct URL class
import org.w3c.files.File

@Composable
actual fun pickMediaFile(onFilePicked: (String?) -> Unit) {
    // Create hidden input element dynamically
    val input = document.createElement("input") as HTMLInputElement
    input.type = "file"
    input.accept = "image/*,video/*"

    // Handle file selection
    input.onchange = {
        val file: File? = input.files?.item(0)
        val url: String? = if (file != null) {
            // Use the imported URL class to call createObjectURL
            URL.createObjectURL(file)
        } else null

        onFilePicked(url)
    }

    // Trigger browser file picker
    input.click()
}
