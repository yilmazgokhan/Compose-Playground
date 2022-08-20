package com.yilmazgokhan.composeplayground.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.yilmazgokhan.composeplayground.ui.component.ButtonDefault
import com.yilmazgokhan.composeplayground.utils.NavDirections

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        ButtonDefault(
            text = "List",
            click = { navController.navigate(NavDirections.BASIC_LIST_SCREEN) }
        )
        ButtonDefault(
            text = "Details",
            click = { navController.navigate(NavDirections.DETAILS_SCREEN) }
        )
    }
}