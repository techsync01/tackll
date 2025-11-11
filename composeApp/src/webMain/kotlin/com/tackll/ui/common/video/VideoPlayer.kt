package com.tackll.common.video

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.attributes.*

@Composable
actual fun VideoPlayer(
    url: String,
    modifier: Modifier,
    autoPlay: Boolean,
    loop: Boolean,
    showProgressAlways: Boolean,
    thumbnail: String
) {
    // Compose for Web uses HTML elements directly
    Video(
        attrs = {
            attr("src", url)
            attr("playsinline", "")
            if (autoPlay) attr("autoplay", "")
            if (loop) attr("loop", "")
            attr("controls", if (showProgressAlways) "" else null)
            attr("poster", thumbnail)
            style {
                property("width", "100%")
                property("height", "100%")
                property("object-fit", "cover")
                property("border-radius", "12px")
            }
        }
    )
}
