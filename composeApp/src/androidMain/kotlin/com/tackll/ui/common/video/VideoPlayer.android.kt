//
//package com.tackll.common.video
//
//import android.net.Uri
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.DisposableEffect
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.viewinterop.AndroidView
//import androidx.media3.common.MediaItem
//import androidx.media3.common.Player
//import androidx.media3.exoplayer.ExoPlayer
//import androidx.media3.ui.PlayerView
//
//@Composable
//actual fun VideoPlayer(
//    url: String,
//    modifier: Modifier,
//    autoPlay: Boolean,
//    loop: Boolean
//) {
//    val context = LocalContext.current
//
//    // 1. Remember the ExoPlayer instance to avoid re-creating it on recomposition
//    val exoPlayer = remember {
//        ExoPlayer.Builder(context).build().apply {
//            val mediaItem = MediaItem.fromUri(Uri.parse(url))
//            setMediaItem(mediaItem)
//            prepare()
//            playWhenReady = autoPlay
//            repeatMode = if (loop) Player.REPEAT_MODE_ALL else Player.REPEAT_MODE_OFF
//        }
//    }
//
//    // 2. Use DisposableEffect to release the player when the composable is disposed
//    DisposableEffect(Unit) {
//        onDispose {
//            exoPlayer.release()
//        }
//    }
//
//    // 3. Use the standard PlayerView from Media3
//    AndroidView(
//        factory = {
//            PlayerView(it).apply {
//                player = exoPlayer
//                useController = true // Set to true to show player controls
//            }
//        },
//        modifier = modifier
//    )
//}



//package com.tackll.common.video
//
//import android.net.Uri
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.LinearProgressIndicator
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.runtime.*
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.viewinterop.AndroidView
//import androidx.media3.common.MediaItem
//import androidx.media3.common.Player
//import androidx.media3.exoplayer.ExoPlayer
//import androidx.media3.ui.AspectRatioFrameLayout
//import androidx.media3.ui.PlayerView
//import kotlinx.coroutines.delay
//
//@Composable
//actual fun VideoPlayer(
//    url: String,
//    modifier: Modifier,
//    autoPlay: Boolean,
//    loop: Boolean,
//    showProgressAlways: Boolean,
//    thumbnail:String
//) {
//    val context = LocalContext.current
//
//    // State for our custom progress bar
//    var currentPosition by remember { mutableLongStateOf(0L) }
//    var duration by remember { mutableLongStateOf(0L) }
//    var isPlaying by remember { mutableStateOf(autoPlay) }
//
//    // ✅ Remember ExoPlayer instance
//    val exoPlayer = remember {
//        ExoPlayer.Builder(context).build().apply {
//            setMediaItem(MediaItem.fromUri(Uri.parse(url)))
//            prepare()
//            playWhenReady = autoPlay
//            repeatMode = if (loop) Player.REPEAT_MODE_ALL else Player.REPEAT_MODE_OFF
//        }
//    }
//
//    // ✅ Listen to player state changes
//    DisposableEffect(exoPlayer) {
//        val listener = object : Player.Listener {
//            override fun onEvents(player: Player, events: Player.Events) {
//                super.onEvents(player, events)
//                duration = player.duration
//                currentPosition = player.currentPosition
//                isPlaying = player.isPlaying
//            }
//        }
//        exoPlayer.addListener(listener)
//
//        onDispose {
//            exoPlayer.removeListener(listener)
//        }
//    }
//
//    // ✅ Periodically update progress while playing
//    LaunchedEffect(isPlaying) {
//        while(isPlaying) {
//            currentPosition = exoPlayer.currentPosition
//            delay(1000) // Update every second
//        }
//    }
//
//    // Release player when composable is removed
//    DisposableEffect(Unit) {
//        onDispose { exoPlayer.release() }
//    }
//
//    Box(modifier = modifier) {
//        // ✅ PlayerView setup (Reels style)
//        AndroidView(
//            factory = {
//                PlayerView(it).apply {
//                    player = exoPlayer
//                    useController = false // Hide default controls
//                    resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL
//                    setShutterBackgroundColor(Color.Black.hashCode())
//                }
//            },
//            modifier = Modifier.clickable {
//                // Toggle play/pause on tap
//                if (exoPlayer.isPlaying) exoPlayer.pause() else exoPlayer.play()
//            }
//        )
//
//        // ✅ Our custom Compose-based progress bar
//        LinearProgressIndicator(
//            progress = { if (duration > 0) currentPosition.toFloat() / duration else 0f },
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp, vertical = 8.dp),
//            color = Color.White,
//            trackColor = Color.White.copy(alpha = 0.3f)
//        )
//    }
//}

package com.tackll.common.video

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import coil3.compose.AsyncImage
import kotlinx.coroutines.delay

@Composable
actual fun VideoPlayer(
    url: String,
    modifier: Modifier,
    autoPlay: Boolean,
    loop: Boolean,
    showProgressAlways: Boolean,
    thumbnail:String
) {
    val context = LocalContext.current

    var currentPosition by remember { mutableLongStateOf(0L) }
    var duration by remember { mutableLongStateOf(0L) }
    var isPlaying by remember { mutableStateOf(autoPlay) }
    var hasStarted by remember { mutableStateOf(false) }

    // Build ExoPlayer lazily
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(Uri.parse(url)))
            prepare()
            playWhenReady = autoPlay
            repeatMode = if (loop) Player.REPEAT_MODE_ALL else Player.REPEAT_MODE_OFF
        }
    }

    // Listen to state changes
    DisposableEffect(exoPlayer) {
        val listener = object : Player.Listener {
            override fun onEvents(player: Player, events: Player.Events) {
                duration = player.duration
                currentPosition = player.currentPosition
                isPlaying = player.isPlaying
                if (player.playbackState == Player.STATE_READY) hasStarted = true
            }
        }
        exoPlayer.addListener(listener)
        onDispose {
            exoPlayer.removeListener(listener)
            exoPlayer.release()
        }
    }

    // Update progress every second
    LaunchedEffect(isPlaying) {
        while (isPlaying) {
            currentPosition = exoPlayer.currentPosition
            delay(1000)
        }
    }

    Box(modifier = modifier) {
        // ✅ Always show thumbnail until playback starts
        if (!hasStarted) {
            AsyncImage(
                model = thumbnail,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        // ✅ PlayerView setup
        AndroidView(
            factory = {
                PlayerView(it).apply {
                    player = exoPlayer
                    useController = false
                    resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                    setShutterBackgroundColor(Color.Black.hashCode())
                }
            },
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    if (exoPlayer.isPlaying) exoPlayer.pause() else exoPlayer.play()
                }
        )

        //  Optional progress bar
        if (showProgressAlways) {
            LinearProgressIndicator(
                progress = { if (duration > 0) currentPosition.toFloat() / duration else 0f },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(bottom = 30.dp, start = 16.dp, end = 16.dp),
                color = Color.White,
                trackColor = Color.White.copy(alpha = 0.3f)
            )
        }
    }
}

