
package com.tackll.ui.screens.profile.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProgressStepper(
    steps: List<String>,
    activeIndex: Int = 0,
    activeBubbleText: String = "15",
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        ) {
                val inactiveColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
            // === Base Line ===
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .align(Alignment.Center)
            ) {
                val activeColor = Color(0xFF4CAF50) // soft green line like your reference

                val totalWidth = size.width
                val segmentWidth = totalWidth / (steps.size - 1)
                val progressX = activeIndex * segmentWidth

                // Draw the full thin line
                drawLine(
                    color = inactiveColor,
                    start = Offset(0f, size.height / 2),
                    end = Offset(totalWidth, size.height / 2),
                    strokeWidth = 3f,
                    cap = StrokeCap.Round
                )

                // Draw the active green progress part
                drawLine(
                    color = activeColor,
                    start = Offset(0f, size.height / 2),
                    end = Offset(progressX, size.height / 2),
                    strokeWidth = 3f,
                    cap = StrokeCap.Round
                )

                // Small green dot at the start
                drawCircle(
                    color = activeColor,
                    radius = 4.dp.toPx(),
                    center = Offset(0f, size.height / 2)
                )
            }

            // === Step Circles and Labels ===
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(horizontal = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                steps.forEachIndexed { index, label ->
                    val isCompleted = index <= activeIndex
                    val isActive = index == activeIndex

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(contentAlignment = Alignment.Center) {
                            // Step circle
                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .offset(y = (10).dp)
                                    .clip(CircleShape)
                                    .background(
                                        if (isCompleted)
                                            MaterialTheme.colorScheme.primary
                                        else
                                            Color.Gray
                                    )
                                    .border(
                                        width = 2.dp,
                                        color = if (isCompleted)
                                            MaterialTheme.colorScheme.primary
                                        else
                                            MaterialTheme.colorScheme.outline,
                                        shape = CircleShape
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    "✓",
                                    color = if (isCompleted)
                                        MaterialTheme.colorScheme.onPrimary
                                    else
                                        MaterialTheme.colorScheme.onSurfaceVariant,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            }

                            // Bubble for active one
                            if (isActive) {
                                Box(
                                    modifier = Modifier
                                        .align(Alignment.TopCenter)
                                        .offset(y = (-20).dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Surface(
                                        color = MaterialTheme.colorScheme.surfaceVariant,
                                        shape = MaterialTheme.shapes.small,
                                        shadowElevation = 2.dp
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .padding(horizontal = 8.dp, vertical = 2.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = activeBubbleText,
                                                style = MaterialTheme.typography.bodySmall.copy(
                                                    fontSize = 12.sp,
                                                    color = MaterialTheme.colorScheme.onSurface
                                                )
                                            )
                                        }
                                    }
                                    val col = MaterialTheme.colorScheme.surfaceVariant
                                    // Pointer triangle
                                    Canvas(
                                        modifier = Modifier
                                            .size(width = 10.dp, height = 6.dp)
                                            .align(Alignment.BottomCenter)
                                            .offset(y = 10.dp)
                                    ) {
                                        val path = Path().apply {
                                            moveTo(0f, 0f)
                                            lineTo(size.width / 2, size.height)
                                            lineTo(size.width, 0f)
                                            close()
                                        }
                                        drawPath(
                                            path = path,
                                            color = col
                                        )
                                    }
                                }
                            }
                        }

                        Spacer(Modifier.height(15.dp))
                        Text(
                            text = label,
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        )
                    }
                }
            }
        }
    }
}
