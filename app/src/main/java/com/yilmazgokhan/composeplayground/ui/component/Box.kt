package com.yilmazgokhan.composeplayground.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InfoBox(
    text: String,
    textColor: Color = Color.LightGray,
    shapeRadius: Int = 4
) {
    Card(
        border = BorderStroke(2.dp, textColor),
        backgroundColor = Color.White,
        shape = RoundedCornerShape(shapeRadius)
    ) {
        TextTiny(
            text = text.uppercase(),
            color = textColor,
            fontSize = 12.sp,
            maxLines = 1,
            modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
        )

    }
}