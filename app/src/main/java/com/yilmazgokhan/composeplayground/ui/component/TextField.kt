package com.yilmazgokhan.composeplayground.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.yilmazgokhan.composeplayground.R
import com.yilmazgokhan.composeplayground.ui.theme.Purple700

@Composable
fun TextFieldDefault(
    info: String?,
    text: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier.padding(horizontal = 2.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        info?.let {
            TextSecondary(text = it)
        }
        Surface(
            shape = MaterialTheme.shapes.small,
            color = Color.White,
            border = BorderStroke(
                width = 1.dp,
                color = Purple700
            )
        ) {
            TextField(modifier = Modifier.fillMaxWidth(),
                value = text,
                onValueChange = {/* TODO */ }
            )
        }
    }
}

// TODO: Add state
@Composable
fun TextFieldDefault(
    text: String,
    label: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    leadingIcon: ImageVector?,
    contentDescription: String,
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        singleLine = true,
        leadingIcon = {
            if (leadingIcon != null) {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = contentDescription
                )
            }
        },
        onValueChange = onValueChange,
        label = { Text(text = label) },
        placeholder = { Text(text = placeholder) },
    )
}

@Composable
fun temp(
    value: String,
    icon: ImageVector,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    passVisible: Boolean = false
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "lockIcon"
            )
        },
        onValueChange = { onValueChange },
        label = { Text(text = label) },
        placeholder = { Text(text = placeholder) },
        visualTransformation = if (passVisible) VisualTransformation.None
        else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (passVisible) {
                R.drawable.ic_baseline_visibility_24
            } else {
                R.drawable.ic_baseline_visibility_off_24
            }
            val description = if (passVisible) "Hide password" else "Show password"

            // TODO:  
            /*
            IconButton(onClick = { passVisible = !passVisible }) {
                Icon(
                    painter = painterResource(id = image),
                    description
                )
            }
             */
        }
    )
}