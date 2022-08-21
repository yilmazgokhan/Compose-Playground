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
import androidx.compose.ui.unit.dp
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