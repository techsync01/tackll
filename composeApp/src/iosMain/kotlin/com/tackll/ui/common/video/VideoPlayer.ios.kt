//
//package com.tackll.common.video
//
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.interop.UIKitView
//import platform.AVFoundation.AVPlayer
//import platform.AVFoundation.play
//import platform.AVKit.AVPlayerViewController
//import platform.Foundation.NSURL
//
//@Composable
//actual fun VideoPlayer(
//    url: String,
//    modifier: Modifier,
//    autoPlay: Boolean,
//    loop: Boolean
//) {
//    androidx.compose.ui.viewinterop.UIKitView(
//        factory = {
//            val player = AVPlayer(uRL = NSURL(string = url))
//            val controller = AVPlayerViewController().apply {
//                this.player = player
//            }
//            if (autoPlay) player.play()
//            controller.view
//        },
//        modifier = modifier
//    )
//}


package com.tackll.common.video

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.viewinterop.UIKitView
import coil3.compose.AsyncImage
import kotlinx.cinterop.CValue
import kotlinx.coroutines.delay
import platform.AVFoundation.*
import platform.AVKit.AVPlayerViewController
import platform.CoreMedia.CMTime
import platform.CoreMedia.CMTimeMakeWithSeconds
import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSURL
import platform.UIKit.UIView
import platform.QuartzCore.CATransaction
import platform.darwin.NSObject

@Composable
actual fun VideoPlayer(
    url: String,
    modifier: Modifier,
    autoPlay: Boolean,
    loop: Boolean,
    showProgressAlways: Boolean,
    thumbnail: String
) {
    var hasStarted by remember { mutableStateOf(false) }
    var duration by remember { mutableDoubleStateOf(0.0) }
    var currentTime by remember { mutableDoubleStateOf(0.0) }

    UIKitView(
        factory = {
            val player = AVPlayer(uRL = NSURL(string = url))
            val playerLayer = AVPlayerLayer.playerLayerWithPlayer(player)
            val container = UIView()

            // Attach player layer to UIView
            playerLayer.videoGravity = AVLayerVideoGravityResizeAspectFill
            playerLayer.frame = container.bounds
            container.layer.addSublayer(playerLayer)

            // Observe playback end for looping
            if (loop) {
                NSNotificationCenter.defaultCenter.addObserverForName(
                    name = AVPlayerItemDidPlayToEndTimeNotification,
                    `object` = player.currentItem,
                    queue = null
                ) { _ ->
                    player.seekToTime(CMTimeMakeWithSeconds(0.0, preferredTimescale = 1))
                    player.play()
                }
            }

            if (autoPlay) player.play()

            // Update progress periodically
            player.addPeriodicTimeObserverForInterval(
                interval = CMTimeMakeWithSeconds(1.0, 1),
                queue = null
            ) { time: CValue<CMTime> ->
                hasStarted = true
                duration = player.currentItem?.duration?.seconds ?: 0.0
                currentTime = player.currentTime().seconds
            }

            container
        },
        update = { view ->
            // Redraw player layer if size changes
            val layer = view.layer.sublayers?.firstOrNull() as? AVPlayerLayer
            CATransaction.begin()
            CATransaction.setDisableActions(true)
            layer?.frame = view.bounds
            CATransaction.commit()
        },
        modifier = modifier
    )

    //  Thumbnail overlay (before playback starts)
    if (!hasStarted && thumbnail.isNotEmpty()) {
        AsyncImage(
            model = thumbnail,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }

    // (Optional) You can later add a Compose progress indicator here using `currentTime` and `duration`
}
