package com.yilmazgokhan.composeplayground.navigation

import com.yilmazgokhan.composeplayground.R

enum class BottomNav(
    val route: String,
    val iconId: Int,
    val screenName: String
) {
    REGISTER(
        NavDirections.Register.route,
        R.drawable.ic_baseline_visibility_24,
        "Register"
    ),
    LOGIN(
        NavDirections.Login.route,
        R.drawable.ic_baseline_visibility_24,
        "Login"
    )
}