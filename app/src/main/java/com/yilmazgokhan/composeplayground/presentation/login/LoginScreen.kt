package com.yilmazgokhan.composeplayground.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.yilmazgokhan.composeplayground.R
import com.yilmazgokhan.composeplayground.ui.component.ButtonWithBorder
import com.yilmazgokhan.composeplayground.ui.component.TextSecondary
import com.yilmazgokhan.composeplayground.ui.theme.Purple200
import com.yilmazgokhan.composeplayground.utils.NavDirections

@Composable
fun LoginScreen(navController: NavController) {
    Scaffold(bottomBar = { LoginBottomBar() },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                var email by remember { mutableStateOf(TextFieldValue("")) }
                var pass by remember { mutableStateOf(TextFieldValue("")) }
                var passVisible by rememberSaveable { mutableStateOf(false) }

                Image(
                    painter = painterResource(id = R.drawable.compose),
                    contentDescription = "appIcon"
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = email,
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "emailIcon"
                        )
                    },
                    onValueChange = {
                        email = it
                    },
                    label = { Text(text = "Email address") },
                    placeholder = { Text(text = "Enter your e-mail") },
                )
                Spacer(modifier = Modifier.height(4.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = pass,
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "lockIcon"
                        )
                    },
                    onValueChange = {
                        pass = it
                    },
                    label = { Text(text = "Password") },
                    placeholder = { Text(text = "Enter your password") },
                    visualTransformation = if (passVisible) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    trailingIcon = {
                        val image = if (passVisible) {
                            R.drawable.ic_baseline_visibility_24
                        } else {
                            R.drawable.ic_baseline_visibility_off_24
                        }
                        val description = if (passVisible) "Hide password" else "Show password"

                        IconButton(onClick = { passVisible = !passVisible }) {
                            Icon(
                                painter = painterResource(id = image),
                                description
                            )
                        }
                    }
                )
                Spacer(modifier = Modifier.height(4.dp))

                ButtonWithBorder(
                    text = "Login",
                    click = {
                        if (pass.text == "" && email.text == "")
                            navController.navigate(NavDirections.HOME_SCREEN)
                    }
                )
                Spacer(modifier = Modifier.height(4.dp))

                ButtonWithBorder(
                    text = "Register",
                    textColor = Color.White,
                    borderColor = Purple200,
                    backgroundColor = Purple200,
                    click = { navController.navigate(NavDirections.REGISTER_SCREEN) }
                )
                Spacer(modifier = Modifier.height(4.dp))
            }

        }
    )
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
