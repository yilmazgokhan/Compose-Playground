package com.yilmazgokhan.composeplayground.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.airbnb.lottie.compose.*
import com.yilmazgokhan.composeplayground.R

@Composable
fun Loading(
    visible: Boolean,
    modifier: Modifier = Modifier
) {
    if (!visible) {
        return
    }
    Box(
        modifier = modifier
            .zIndex(100f)
            .fillMaxSize()
            .clickable(false) { }
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            /*
            Box(
                modifier = Modifier
                    .background(
                        Color(color = 0xFF192E58),
                        RoundedCornerShape(8.dp)
                    )
                    .size(88.dp)
            ) {
                LoadingAnimation(modifier = Modifier.align(Alignment.Center))
            }
             */
            LoadingAnimation(modifier = Modifier.size(90.dp))
        }
    }
}

@Composable
private fun LoadingAnimation(modifier: Modifier = Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever,
    )
    LottieAnimation(
        composition,
        progress = { progress },
        modifier = modifier,
    )
}