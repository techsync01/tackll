
package com.tackll.navigation

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.zIndex

@Composable
fun CurvedBottomBar(
    selectedItem: BottomNavItem,
    onItemSelected: (BottomNavItem) -> Unit,
    darkTheme: Boolean
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Flicks,
        BottomNavItem.Create,
        BottomNavItem.Explore,
        BottomNavItem.Profile
    )

    val barHeight = 90.dp
    val notchRadius = 36.dp
    val circleSize = 46.dp
    val iconSize = 28.dp

    val selectedIndex = items.indexOf(selectedItem)
    var targetCenterX by remember { mutableStateOf(0f) }
    val animatedCenterX by animateFloatAsState(
        targetValue = targetCenterX,
        animationSpec = tween(400)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(barHeight)
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val w = size.width
            val h = size.height
            val itemWidth = w / items.size
            val currentCenterX = itemWidth * (selectedIndex + 0.55f)
            targetCenterX = currentCenterX

            val barPath = Path().apply {
                moveTo(0f, h)
                lineTo(0f, 0f)
                lineTo(w, 0f)
                lineTo(w, h)
                close()
            }

            val notchPath = Path().apply {
                addOval(
                    Rect(
                        center = Offset(animatedCenterX, 0f),
                        radius = notchRadius.toPx()
                    )
                )
            }

            val finalPath = Path.combine(PathOperation.Difference, barPath, notchPath)

            drawPath(
                path = finalPath,
                brush = Brush.verticalGradient(
                    colors = if (darkTheme)
                        listOf(Color(0xFF021934), Color(0xFF032C68))
                    else
                        listOf(Color(0xFF1E3A8A), Color(0xFF3B82F6))
                )
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 4.dp)
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.Bottom
        ) {
            items.forEachIndexed { index, item ->
                val isSelected = item == selectedItem
                val circleColor = if (darkTheme) Color.White else Color(0xFF002A5E)
                val iconTint = if (darkTheme) Color(0xFF002A5E) else Color.White
                val lift by animateDpAsState(if (isSelected) (-36).dp else 0.dp, tween(300))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(72.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) { onItemSelected(item) }
                        .zIndex(if (isSelected) 1f else 0f)
                ) {
                    Box(contentAlignment = Alignment.TopCenter) {
                        if (isSelected) {
                            Box(
                                modifier = Modifier
                                    .offset(y = lift)
                                    .size(circleSize)
                                    .clip(CircleShape)
                                    .background(circleColor),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.title,
                                    tint = iconTint,
                                    modifier = Modifier.size(iconSize)
                                )
                            }
                        } else {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.title,
                                tint = Color.White,
                                modifier = Modifier
                                    .padding(top = 10.dp)
                                    .size(iconSize)
                            )
                        }
                    }

                    Text(
                        text = item.title,
                        fontSize = 12.sp,
                        color = Color.White.copy(alpha = if (isSelected) 1f else 0.8f)
                    )
                }
            }
        }
    }
}




