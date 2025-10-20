package com.tackll.ui.screens.create.createParent.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.tackll.ui.screens.create.components.CreateTopBar
import com.tackll.ui.screens.create.components.StepperBar
import com.tackll.ui.screens.create.model.CreateViewModel
import com.tackll.ui.screens.create.screens.detailsScreen.DetailsScreen
import com.tackll.ui.screens.create.screens.parametersScreen.screen.ParametersScreen
import com.tackll.ui.screens.create.screens.publishScreen.PublishScreen
import com.tackll.ui.screens.create.screens.rewardsScreen.screen.RewardsScreen

@Composable
fun CreateScreen() {
    val viewModel = remember { CreateViewModel() }
    var currentStep by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // Make everything scrollable
    ) {
        CreateTopBar()
        StepperBar(currentStep = currentStep)
        when (currentStep) {
            0 -> DetailsScreen(viewModel) { currentStep++ }
//            1 -> ParametersScreen(onBack = { currentStep-- }, onNext = { currentStep++ })
            1 -> ParametersScreen(viewModel, onBack = { currentStep-- }, onNext = { currentStep++ })
            2 -> RewardsScreen(viewModel, onBack = { currentStep-- }, onNext = { currentStep++ })
//            3 -> PublishScreen(onBack = { currentStep-- },onNext = { currentStep++ })
            3 -> PublishScreen(
                viewModel = viewModel,
                onBack = { currentStep-- },
                onPublish = {
                    println(" Challenge Published Successfully!")
                    // Navigate to Home Page (replace with your actual nav controller)
                    currentStep = 0
                }
            )
        }
    }
}
