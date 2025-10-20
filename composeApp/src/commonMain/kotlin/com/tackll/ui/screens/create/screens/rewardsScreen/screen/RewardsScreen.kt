package com.tackll.ui.screens.create.screens.rewardsScreen.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tackll.ui.screens.create.components.*
import com.tackll.ui.screens.create.model.*
import com.tackll.ui.screens.create.screens.rewardsScreen.components.ChipSelector
import com.tackll.ui.screens.create.screens.rewardsScreen.components.LeaderboardSelector

@Composable
fun RewardsScreen(
    viewModel: CreateViewModel,
    onBack: () -> Unit,
    onNext: () -> Unit
) {
    val scroll = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Completion Reward
        ChipSelector(
            label = "Completion Reward :",
            items = rewardList,
            selectedItem = viewModel.selectedReward,
            otherText = viewModel.otherReward,
            onSelect = { viewModel.selectedReward = it },
            onOtherChange = { viewModel.otherReward = it }
        )

        // Engagement
        ChipSelector(
            label = "Engagement :",
            items = engagementList,
            selectedItem = viewModel.selectedEngagement,
            otherText = viewModel.otherEngagement,
            onSelect = { viewModel.selectedEngagement = it },
            onOtherChange = { viewModel.otherEngagement = it }
        )

        // Leaderboard
        LeaderboardSelector(
            label = "Leaderboard :",
            selectedValue = viewModel.leaderboardEnabled,
            onValueChange = { viewModel.leaderboardEnabled = it }
        )

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onBack,
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f)
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
            ) { Text("BACK") }

            Spacer(modifier = Modifier.width(12.dp))

            Button(
                onClick = {
                    viewModel.printSummary()
                    onNext()
                },
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
            ) { Text("NEXT") }
        }
    }
}
