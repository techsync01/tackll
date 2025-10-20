package com.tackll.ui.screens.create.screens.detailsScreen


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tackll.ui.screens.create.components.*
import com.tackll.ui.screens.create.model.CreateViewModel
import com.tackll.ui.screens.create.model.categoryList

@Composable
fun DetailsScreen(viewModel: CreateViewModel, onNext: () -> Unit,) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Title:", style = MaterialTheme.typography.bodyMedium)
        RoundedTextField(
            value = viewModel.title,
            onValueChange = { viewModel.title = it },
            placeholder = "Enter Title"
        )

        Text("Description:", style = MaterialTheme.typography.bodyMedium)
        RoundedTextField(
            value = viewModel.description,
            onValueChange = { viewModel.description = it },
            placeholder = "Enter Description",
            singleLine = false,
            modifier = Modifier.height(120.dp)
        )

        Text("Category:", style = MaterialTheme.typography.bodyMedium)
        CategoryChips(
            categories = categoryList,
            selected = viewModel.selectedCategory,
            otherText = viewModel.otherCategory,
            onCategorySelect = { viewModel.selectedCategory = it },
            onOtherChange = { viewModel.otherCategory = it }
        )

        Text("Upload:", style = MaterialTheme.typography.bodyMedium)
//        UploadBox()
        UploadBox(viewModel)
//        UploadBox(onFileSelected = { uri -> viewModel.uploadPath = uri?.toString() })

//        Spacer(modifier = Modifier.weight(1f))
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Button(
//                onClick = { viewModel.printSummary() },
//                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
//            ) { Text("SAVE") }
//
//            Button(
//                onClick = onNext,
//                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
//            ) { Text("NEXT") }
//        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 80.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { viewModel.printSummary() },
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.85f)
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
            ) {
                Text("SAVE", style = MaterialTheme.typography.labelLarge)
            }

            Spacer(modifier = Modifier.width(12.dp))

            Button(
                onClick = onNext,
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
            ) {
                Text("NEXT", style = MaterialTheme.typography.labelLarge)
            }
        }
    }
}
