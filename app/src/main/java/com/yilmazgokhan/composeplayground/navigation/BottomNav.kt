package com.yilmazgokhan.composeplayground.navigation

import com.yilmazgokhan.composeplayground.R

enum class BottomNav(
    val route: String,
    val iconId: Int,
    val screenName: String
) {
    HOME(
        NavDirections.Home.route,
        R.drawable.ic_baseline_visibility_24,
        "Home"
    ),
    LOGIN(
        NavDirections.Login.route,
        R.drawable.ic_baseline_visibility_24,
        "Login"
    )
}