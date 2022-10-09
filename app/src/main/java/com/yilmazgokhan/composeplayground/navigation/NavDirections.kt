package com.yilmazgokhan.composeplayground.navigation

sealed class NavDirections(val route: String) {
    object Login : NavDirections("login")
    object Register : NavDirections("register")
    object Home : NavDirections("home")
    object Users : NavDirections("users")
    object Message : NavDirections("message")
    object Details : NavDirections("details")
}
