package com.tackll.common.video



import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun VideoPlayer(
    url: String,
    modifier: Modifier = Modifier,
    autoPlay: Boolean = false,
    loop: Boolean = true,
    showProgressAlways: Boolean=false,
    thumbnail: String,
)

