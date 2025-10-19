package com.tackll.ui.screens.flicks

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tackll.ui.screens.flicks.flicksScreen.components.FlickItem
import com.tackll.ui.screens.flicks.flicksScreen.modal.flicksDummyList

@Composable
fun FlicksScreen() {
    val pagerState = rememberPagerState(pageCount = { flicksDummyList.size })

    VerticalPager(state = pagerState) { page ->
        FlickItem(flick = flicksDummyList[page],)
    }
}
