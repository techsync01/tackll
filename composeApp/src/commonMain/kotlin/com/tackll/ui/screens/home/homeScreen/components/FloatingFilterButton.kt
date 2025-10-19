package com.tackll.ui.screens.home.homeScreen.components
//
//
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.FilterList
//
//@Composable
//fun FloatingFilterButton() {
//    FloatingActionButton(onClick = { /*TODO*/ }) {
//        Icon(Icons.Default.FilterList, contentDescription = "Filter")
//    }
//}

//package com.tackll.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun FloatingFilterButton() {
    FloatingActionButton(onClick = { /* TODO: Handle filter click */ }) {
        Icon(Icons.Default.FilterList, contentDescription = "Filter")
    }
}

