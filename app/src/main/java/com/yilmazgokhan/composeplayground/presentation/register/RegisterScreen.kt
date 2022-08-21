package com.yilmazgokhan.composeplayground.presentation.register

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.yilmazgokhan.composeplayground.R
import com.yilmazgokhan.composeplayground.ui.component.ButtonWithBorder
import com.yilmazgokhan.composeplayground.ui.component.TextSecondary
import com.yilmazgokhan.composeplayground.ui.theme.Purple200

@Composable
fun RegisterScreen(navController: NavController) {
    Scaffold(bottomBar = { BottomBar(navController) }) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                var name by remember { mutableStateOf(TextFieldValue("")) }
                var phone by remember { mutableStateOf(TextFieldValue("")) }
                var email by remember { mutableStateOf(TextFieldValue("")) }
                var address by remember { mutableStateOf(TextFieldValue("")) }

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = name,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "personIcon"
                        )
                    },
                    onValueChange = {
                        name = it
                    },
                    label = { Text(text = "Name") },
                    placeholder = { Text(text = "Name") },
                )
                Spacer(modifier = Modifier.height(4.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = phone,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = "phoneIcon"
                        )
                    },
                    onValueChange = {
                        phone = it
                    },
                    label = { Text(text = "Phone number") },
                    placeholder = { Text(text = "Phone number") },
                )
                Spacer(modifier = Modifier.height(4.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = email,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
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
                    placeholder = { Text(text = "Email address") },
                )
                Spacer(modifier = Modifier.height(4.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = address,
                    singleLine = false,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "addressIcon"
                        )
                    },
                    onValueChange = {
                        address = it
                    },
                    label = { Text(text = "Address") },
                    placeholder = { Text(text = "Address") },
                )
                Spacer(modifier = Modifier.height(4.dp))

                PasswordSelection()
                Spacer(modifier = Modifier.height(12.dp))

                GenderSelection()
                Spacer(modifier = Modifier.height(12.dp))

                TermsAndConditionsSelection()
            }
        }
    }
}

@Composable
fun PasswordSelection() {
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var passVisible by rememberSaveable { mutableStateOf(false) }
    var confirmPass by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPassVisible by rememberSaveable { mutableStateOf(false) }

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
        placeholder = { Text(text = "Password") },
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

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = confirmPass,
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "lockIcon"
            )
        },
        onValueChange = {
            confirmPass = it
        },
        label = { Text(text = "Confirm password") },
        placeholder = { Text(text = "Confirm password") },
        visualTransformation = if (confirmPassVisible) VisualTransformation.None
        else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (confirmPassVisible) {
                R.drawable.ic_baseline_visibility_24
            } else {
                R.drawable.ic_baseline_visibility_off_24
            }
            val description = if (confirmPassVisible) "Hide password" else "Show password"

            IconButton(onClick = { confirmPassVisible = !confirmPassVisible }) {
                Icon(
                    painter = painterResource(id = image),
                    description
                )
            }
        }
    )
}

@Composable
fun GenderSelection() {
    val radioOptions = listOf("Male", "Female")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1]) }
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        radioOptions.forEach { text ->
            Row(modifier = Modifier
                .selectable(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    modifier = Modifier.padding(2.dp),
                    onClick = {
                        onOptionSelected(text)
                    }
                )
                Text(
                    text = text,
                )
            }
        }
    }
}

@Composable
fun TermsAndConditionsSelection() {
    val termsState = remember { mutableStateOf(false) }
    val newsletterState = remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = termsState.value,
            onCheckedChange = { termsState.value = it }
        )
        Spacer(modifier = Modifier.width(4.dp))
        TextSecondary(text = "I agree with terms and conditions")
    }
    Spacer(modifier = Modifier.height(12.dp))

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = newsletterState.value,
            onCheckedChange = { newsletterState.value = it }
        )
        Spacer(modifier = Modifier.width(4.dp))
        TextSecondary(text = "I want to receive the newsletter")
    }
}

@Composable
fun BottomBar(navController: NavController) {
    Box(modifier = Modifier.padding(4.dp)) {
        ButtonWithBorder(
            text = "Register",
            textColor = Color.White,
            borderColor = Purple200,
            backgroundColor = Purple200,
            click = {
                navController.popBackStack()
            }
        )
    }
}