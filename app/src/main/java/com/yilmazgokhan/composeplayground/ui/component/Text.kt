package com.yilmazgokhan.composeplayground.ui.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun TextDefault(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.W700,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        maxLines = maxLines
    )
}

@Composable
fun TextSecondary(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Gray,
    fontSize: TextUnit = 14.sp,
    fontWeight: FontWeight = FontWeight.W500,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        maxLines = maxLines
    )
}

@Composable
fun TextTiny(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.LightGray,
    fontSize: TextUnit = 14.sp,
    fontWeight: FontWeight = FontWeight.W500,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        maxLines = maxLines
    )
}