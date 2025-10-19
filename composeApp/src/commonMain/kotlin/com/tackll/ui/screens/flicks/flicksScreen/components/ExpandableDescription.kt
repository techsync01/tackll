package com.tackll.ui.screens.flicks.flicksScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun ExpandableDescription(
    text: String,
    expanded: Boolean,
    onToggle: () -> Unit
) {
    val textColor = MaterialTheme.colorScheme.onBackground
    val toggleColor = textColor.copy(alpha = 0.7f)

    val preview = if (text.length > 20) text.take(20) + "..." else text
    val displayText = if (expanded) text else preview
    val toggleLabel = if (expanded) "...see less" else "...see more"

    Column {
        Text(text = displayText, color = textColor)
        Text(
            text = toggleLabel,
            color = toggleColor,
            modifier = Modifier.clickable { onToggle() }
        )
    }
}


//@Composable
//fun ExpandableDescription(
//    text: String,
//    expanded: Boolean,
//    onToggle: () -> Unit
//) {
//    val preview = if (text.length > 20) text.take(20) + "..." else text
//    val displayText = if (expanded) text else preview
//    val toggleLabel = if (expanded) "...see less" else "...see more"
//
//    Column {
//        Text(text = displayText, color = Color.White)
//        Text(
//            text = toggleLabel,
//            color = Color.White.copy(alpha = 0.7f),
//            modifier = Modifier.clickable { onToggle() }
//        )
//    }
//}
