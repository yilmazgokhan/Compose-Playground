package com.yilmazgokhan.composeplayground.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yilmazgokhan.composeplayground.ui.component.ButtonDefault

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navigateToLogin: () -> Unit,
    navigateToList: () -> Unit,
    navigateToRegister: () -> Unit,
    navigateToDetails: () -> Unit,
    navigateToMessages: () -> Unit,
) {

    val viewState by viewModel.uiState.collectAsState()
    Column(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        ButtonDefault(
            text = "Login",
            click = { navigateToLogin() }
        )
        ButtonDefault(
            text = "Register",
            click = { navigateToRegister() }
        )
        ButtonDefault(
            text = "List",
            click = { navigateToList() }
        )
        ButtonDefault(
            text = "Details",
            click = { }
        )
        ButtonDefault(
            text = "Messages",
            click = { navigateToMessages() }
        )
    }
}