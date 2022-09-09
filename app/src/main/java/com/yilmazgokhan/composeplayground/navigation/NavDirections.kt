package com.yilmazgokhan.composeplayground.navigation


sealed class NavScreen(val route: String) {
    object LOGIN_SCREEN : NavScreen("login")
    object REGISTER_SCREEN : NavScreen("register")
    object HOME_SCREEN : NavScreen("home")
    object BASIC_LIST_SCREEN : NavScreen("basic_list")
    object DETAILS_SCREEN : NavScreen("details")
}
