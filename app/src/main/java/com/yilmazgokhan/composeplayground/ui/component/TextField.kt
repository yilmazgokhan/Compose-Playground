package com.yilmazgokhan.composeplayground.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldDefault(
    info: String?,
    text: String,
    modifier: Modifier = Modifier,
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        color = Color.White,
        border = BorderStroke(
            width = 1.dp,
            color = Color.Red
        )
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 2.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            info?.let {
                TextSecondary(text = it)
            }
            TextField(modifier = Modifier.fillMaxWidth(),
                value = text,
                onValueChange = {/* TODO */ }
            )
        }
    }
}