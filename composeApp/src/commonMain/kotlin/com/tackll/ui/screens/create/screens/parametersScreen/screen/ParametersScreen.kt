//package com.tackll.ui.screens.create.screens.parametersScreen.screen
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.Button
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun ParametersScreen(onBack: () -> Unit, onNext: () -> Unit) {
//    Column (Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
//        Text("Parameters Screen", style = MaterialTheme.typography.titleLarge)
//        Row (horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//            Button(onClick = onBack) { Text("Back") }
//            Button(onClick = onNext) { Text("Next") }
//        }
//    }
//}


package com.tackll.ui.screens.create.screens.parametersScreen.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tackll.ui.screens.create.components.*
import com.tackll.ui.screens.create.model.*
import com.tackll.ui.screens.create.screens.parametersScreen.components.ChipSelector
import com.tackll.ui.screens.create.screens.parametersScreen.components.CustomDropDown
import com.tackll.ui.screens.create.screens.parametersScreen.components.DropDownSelector
import com.tackll.ui.screens.create.screens.parametersScreen.components.InfoLabel

@Composable
fun ParametersScreen(
    viewModel: CreateViewModel = CreateViewModel(),
    onBack: () -> Unit,
    onNext: () -> Unit,
) {
    val scroll = rememberScrollState()


    Column(
        modifier = Modifier
            .fillMaxSize()
//            .verticalScroll(scroll)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Challenge Duration
        InfoLabel("Challenge needs to be completed in :")
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            CustomDropDown(
//                items = (1..31).map { String.format("%02d", it) },
                items = (1..31).map { it.toString().padStart(2, '0') },
                selectedValue = viewModel.challengeDuration,
                onSelect = { viewModel.challengeDuration = it },
                modifier = Modifier.weight(1f)
            )
            CustomDropDown(
                items = durationTypes,
                selectedValue = viewModel.challengeDurationType,
                onSelect = { viewModel.challengeDurationType = it },
                modifier = Modifier.weight(1f)
            )
        }

        // Submission Required
        ChipSelector(
            label = "Submission Required :",
            items = submissionTypes,
            selectedItem = viewModel.selectedSubmission,
            otherText = viewModel.otherSubmission,
            onSelect = { viewModel.selectedSubmission = it },
            onOtherChange = { viewModel.otherSubmission = it }
        )

        // Participation Criteria
        ChipSelector(
            label = "Participation Criteria :",
            items = criteriaList,
            selectedItem = viewModel.selectedCriteria,
            otherText = viewModel.otherCriteria,
            onSelect = { viewModel.selectedCriteria = it },
            onOtherChange = { viewModel.otherCriteria = it }
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
