package com.yilmazgokhan.composeplayground.presentation.login

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.yilmazgokhan.composeplayground.ui.component.ButtonWithBorder
import com.yilmazgokhan.composeplayground.utils.NavDirections

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {

        ButtonWithBorder(
            text = "Login",
            click = { navController.navigate(NavDirections.HOME_SCREEN) }
        )
        Spacer(modifier = Modifier.height(4.dp))
        ButtonWithBorder(
            text = "Register",
            click = { navController.navigate(NavDirections.REGISTER_SCREEN) }
        )
    }
}