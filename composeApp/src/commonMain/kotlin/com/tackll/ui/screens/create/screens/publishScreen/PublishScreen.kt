//package com.tackll.ui.screens.create.screens.publishScreen
//
//
//
//
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import com.tackll.ui.screens.create.model.CreateViewModel
//import kotlinx.coroutines.launch
//
//@Composable
//fun PublishScreen(
//    viewModel: CreateViewModel,
//    onBack: () -> Unit,
//    onPublish: () -> Unit
//) {
//    val snackbarHostState = remember { SnackbarHostState() }
//    val scope = rememberCoroutineScope()
//
//        // The main content is now scrollable, and the buttons are fixed at the bottom.
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
////                .padding(innerPadding) // Apply padding from the Scaffold
////                .verticalScroll(rememberScrollState()) // Make the summary content scrollable
//                .padding(horizontal = 16.dp, vertical = 12.dp),
//            verticalArrangement = Arrangement.spacedBy(18.dp)
//        ) {
//            // This is the content that will scroll if it's too long
//            Text(
//                text = "•  Title : ${viewModel.title.ifBlank { "-" }}",
//                style = MaterialTheme.typography.bodyLarge
//            )
//
//            Text(
//                text = "•  Description : ${if (viewModel.description.isNotBlank()) viewModel.description else "-"}",
//                style = MaterialTheme.typography.bodyLarge
//            )
//
//            Text(
//                text = "•  Category : ${viewModel.selectedCategory ?: viewModel.otherCategory.ifBlank { "-" }}",
//                style = MaterialTheme.typography.bodyLarge
//            )
//
//            Text(text = "•  Upload :", style = MaterialTheme.typography.bodyLarge)
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(180.dp)
//                    .background(
//                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.12f),
//                        shape = RoundedCornerShape(12.dp)
//                    ),
//                contentAlignment = Alignment.Center
//            ) {
//                val uploadPath = viewModel.uploadPath
//                if (uploadPath.isNullOrEmpty()) {
//                    Text("No file selected", style = MaterialTheme.typography.bodyMedium)
//                } else {
//                    Text(
//                        text = uploadPath.substringAfterLast('/'),
//                        style = MaterialTheme.typography.bodyLarge
//                    )
//                }
//            }
//
//            Text(
//                text = "•  Challenge needs to be completed in : ${viewModel.challengeDuration} ${viewModel.challengeDurationType}",
//                style = MaterialTheme.typography.bodyLarge
//            )
//
//            val submission = listOfNotNull(
//                viewModel.selectedSubmission,
//                viewModel.otherSubmission.takeIf { it.isNotBlank() }
//            ).joinToString(" and ").ifBlank { "-" }
//            Text("•  Submission Required : $submission", style = MaterialTheme.typography.bodyLarge)
//
//            val criteria = listOfNotNull(
//                viewModel.selectedCriteria,
//                viewModel.otherCriteria.takeIf { it.isNotBlank() }
//            ).joinToString(" and ").ifBlank { "-" }
//            Text("•  Participation Criteria : $criteria", style = MaterialTheme.typography.bodyLarge)
//
//            val reward = listOfNotNull(
//                viewModel.selectedReward,
//                viewModel.otherReward.takeIf { it.isNotBlank() }
//            ).joinToString(" and ").ifBlank { "-" }
//            Text("•  Rewards : $reward", style = MaterialTheme.typography.bodyLarge)
//
//            val engagement = listOfNotNull(
//                viewModel.selectedEngagement,
//                viewModel.otherEngagement.takeIf { it.isNotBlank() }
//            ).joinToString(" and ").ifBlank { "-" }
//            Text("•  Engagement : $engagement", style = MaterialTheme.typography.bodyLarge)
//
//            val leaderboard = when (viewModel.leaderboardEnabled) {
//                true -> "Yes"
//                false -> "No"
//                else -> "-"
//            }
//            Text("•  Leaderboard : $leaderboard", style = MaterialTheme.typography.bodyLarge)
//
//            // The Spacer with weight is no longer needed here because the buttons are in the bottomBar
//            Spacer(modifier = Modifier.weight(1f))
//
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Button(
//                    onClick = onBack,
//                    modifier = Modifier
//                        .weight(1f)
//                        .height(48.dp)
//                        .padding(end = 8.dp)
//                ) {
//                    Text("BACK")
//                }
//
//                Button(
//                    onClick = {
//                        viewModel.printSummary()
//                        scope.launch {
//                            snackbarHostState.showSnackbar(
//                                message = "Successfully published",
//                                duration = SnackbarDuration.Short
//                            )
//                            onPublish()
//                        }
//                    },
//                    modifier = Modifier
//                        .weight(1f)
//                        .height(48.dp)
//                ) {
//                    Text("PUBLISH")
//                }
//            }
//        }
//    }
//



package com.tackll.ui.screens.create.screens.publishScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tackll.ui.screens.create.model.CreateViewModel
import kotlinx.coroutines.launch

@Composable
fun PublishScreen(
    viewModel: CreateViewModel,
    onBack: () -> Unit,
    onPublish: () -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    // Outer Box handles layering so snackbar can float above content
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(18.dp),
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Text("•  Title : ${viewModel.title.ifBlank { "-" }}", style = MaterialTheme.typography.bodyLarge)
            Text(
                "•  Description : ${if (viewModel.description.isNotBlank()) viewModel.description else "-"}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                "•  Category : ${viewModel.selectedCategory ?: viewModel.otherCategory.ifBlank { "-" }}",
                style = MaterialTheme.typography.bodyLarge
            )

            Text("•  Upload :", style = MaterialTheme.typography.bodyLarge)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.12f),
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                val uploadPath = viewModel.uploadPath
                if (uploadPath.isNullOrEmpty()) {
                    Text("No file selected", style = MaterialTheme.typography.bodyMedium)
                } else {
                    Text(uploadPath.substringAfterLast('/'), style = MaterialTheme.typography.bodyLarge)
                }
            }

            Text(
                "•  Challenge needs to be completed in : ${viewModel.challengeDuration} ${viewModel.challengeDurationType}",
                style = MaterialTheme.typography.bodyLarge
            )

            val submission = listOfNotNull(
                viewModel.selectedSubmission,
                viewModel.otherSubmission.takeIf { it.isNotBlank() }
            ).joinToString(" and ").ifBlank { "-" }
            Text("•  Submission Required : $submission", style = MaterialTheme.typography.bodyLarge)

            val criteria = listOfNotNull(
                viewModel.selectedCriteria,
                viewModel.otherCriteria.takeIf { it.isNotBlank() }
            ).joinToString(" and ").ifBlank { "-" }
            Text("•  Participation Criteria : $criteria", style = MaterialTheme.typography.bodyLarge)

            val reward = listOfNotNull(
                viewModel.selectedReward,
                viewModel.otherReward.takeIf { it.isNotBlank() }
            ).joinToString(" and ").ifBlank { "-" }
            Text("•  Rewards : $reward", style = MaterialTheme.typography.bodyLarge)

            val engagement = listOfNotNull(
                viewModel.selectedEngagement,
                viewModel.otherEngagement.takeIf { it.isNotBlank() }
            ).joinToString(" and ").ifBlank { "-" }
            Text("•  Engagement : $engagement", style = MaterialTheme.typography.bodyLarge)

            val leaderboard = when (viewModel.leaderboardEnabled) {
                true -> "Yes"
                false -> "No"
                else -> "-"
            }
            Text("•  Leaderboard : $leaderboard", style = MaterialTheme.typography.bodyLarge)

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = onBack,
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .padding(end = 8.dp)
                ) { Text("BACK") }

                Button(
                    onClick = {
                        viewModel.printSummary()
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "Successfully published",
                                duration = SnackbarDuration.Short
                            )
                            onPublish()
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                ) { Text("PUBLISH") }
            }
        }

        // Floating Snackbar at bottom center
        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        )
    }
}
