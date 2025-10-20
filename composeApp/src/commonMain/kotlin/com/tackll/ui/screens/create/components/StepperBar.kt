package com.tackll.ui.screens.create.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp


@Composable
fun StepperBar(currentStep: Int) {
    val steps = listOf("Details", "Parameters", "Rewards", "Publish")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically // Align items vertically for better look
    ) {
        steps.forEachIndexed { index, step ->
            // Step Icon and Label
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = step,
                    tint = if (index <= currentStep) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
                )
                Text(
                    text = step,
                    style = MaterialTheme.typography.labelMedium,
                    color = if (index == currentStep) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }

            // Connector Line (The Fix)
            if (index < steps.lastIndex) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(3.dp) // Use height for thickness
                        .padding(horizontal = 4.dp)
                        .background(
                            color = if (index < currentStep) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
                        )
                )
            }
        }
    }
}
