package com.yilmazgokhan.composeplayground.presentation.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.yilmazgokhan.composeplayground.ui.component.ButtonWithBorder
import com.yilmazgokhan.composeplayground.ui.component.TextFieldDefault
import com.yilmazgokhan.composeplayground.ui.component.TextSecondary
import com.yilmazgokhan.composeplayground.utils.NavDirections

@Composable
fun LoginScreen(navController: NavController) {
    Scaffold(bottomBar = { LoginBottomBar() }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {

            TextFieldDefault(
                info = "E-Posta",
                text = "E-posta adresinizi giriniz"
            )
            Spacer(modifier = Modifier.height(4.dp))

            TextFieldDefault(
                info = "Şifre",
                text = "Şifre giriniz"
            )
            Spacer(modifier = Modifier.height(4.dp))

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
}

@Composable
fun LoginBottomBar() {
    TextSecondary(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        text = "Privacy Policy and Terms of Service",
        textAlign = TextAlign.Center

    )
}