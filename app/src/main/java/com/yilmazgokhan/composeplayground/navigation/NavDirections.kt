package com.yilmazgokhan.composeplayground.navigation

sealed class NavDirections(val route: String) {
    object Login : NavDirections("login")
    object Register : NavDirections("register")
    object Home : NavDirections("home")
    object BasicList : NavDirections("basic_list")
    object Message : NavDirections("message")
    object Details : NavDirections("details")
}
