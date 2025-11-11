////package com.tackll.ui.common.video
////
////
////import androidx.compose.runtime.Composable
////import androidx.compose.ui.Modifier
////import androidx.compose.ui.awt.SwingPanel
////import javafx.embed.swing.JFXPanel
////import javafx.scene.media.Media
////import javafx.scene.media.MediaPlayer
////import javafx.scene.media.MediaView
////
////@Composable
////actual fun VideoPlayer(
////    url: String,
////    modifier: Modifier,
////    autoPlay: Boolean,
////    loop: Boolean,
////    showControls: Boolean
////) {
////    SwingPanel(
////        factory = {
////            JFXPanel().also {
////                val media = Media(url)
////                val player = MediaPlayer(media)
////                if (loop) player.setCycleCount(MediaPlayer.INDEFINITE)
////                if (autoPlay) player.play()
////                MediaView(player)
////            }
////        },
////        modifier = modifier
////    )
////}
//
//
//package com.tackll.shared.video
//
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.awt.SwingPanel
//import androidx.compose.ui.viewinterop.SwingPanel
//import javafx.embed.swing.JFXPanel
//import javafx.scene.media.Media
//import javafx.scene.media.MediaPlayer
//import javafx.scene.media.MediaView
//import javax.print.attribute.standard.Media
//
//@Composable
//actual fun VideoPlayer(
//    url: String,
//    modifier: Modifier,
//    autoPlay: Boolean,
//    loop: Boolean
//) {
//    SwingPanel(
//        factory = {
//            JFXPanel().apply {
//                val media = Media(url)
//                val player = MediaPlayer(media)
//                if (autoPlay) player.play()
//                val view = MediaView(player)
//                contentPane.add(view)
//            }
//        },
//        modifier = modifier
//    )
//}


package com.tackll.common.video

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import androidx.compose.ui.graphics.vector.Group
import com.tackll.Platform
import javafx.application.Platform
import javafx.embed.swing.JFXPanel
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.media.Media
import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView
import javax.swing.JPanel

@Composable
actual fun VideoPlayer(
    url: String,
    modifier: Modifier,
    autoPlay: Boolean,
    loop: Boolean,
    showProgressAlways: Boolean,
    thumbnail: String
) {
    SwingPanel(
        factory = {
            //  JFXPanel initializes JavaFX runtime
            val jfxPanel = JFXPanel()

            Platform.runLater {
                try {
                    val media = Media(url)
                    val mediaPlayer = MediaPlayer(media)

                    // Configure player
                    if (loop) mediaPlayer.cycleCount = MediaPlayer.INDEFINITE
                    mediaPlayer.isAutoPlay = autoPlay

                    val mediaView = MediaView(mediaPlayer)
                    mediaView.fitWidthProperty().bind(jfxPanel.widthProperty())
                    mediaView.fitHeightProperty().bind(jfxPanel.heightProperty())
                    mediaView.isPreserveRatio = true

                    val root = Group(mediaView)
                    val scene = Scene(root, jfxPanel.width.toDouble(), jfxPanel.height.toDouble())
                    jfxPanel.scene = scene
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            // Return Swing container for Compose
            JPanel().apply { add(jfxPanel) }
        },
        modifier = modifier
    )
}
