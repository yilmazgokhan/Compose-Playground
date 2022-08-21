package com.yilmazgokhan.composeplayground.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yilmazgokhan.composeplayground.presentation.home.HomeScreen
import com.yilmazgokhan.composeplayground.presentation.list.BasicListView
import com.yilmazgokhan.composeplayground.presentation.login.LoginScreen
import com.yilmazgokhan.composeplayground.presentation.main.DetailScreen
import com.yilmazgokhan.composeplayground.presentation.register.RegisterScreen

@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavDirections.LOGIN_SCREEN
    ) {
        composable(NavDirections.LOGIN_SCREEN) {
            LoginScreen(navController)
        }
        composable(NavDirections.REGISTER_SCREEN) {
            RegisterScreen(navController)
        }
        composable(NavDirections.HOME_SCREEN) {
            HomeScreen(navController)
        }
        composable(NavDirections.BASIC_LIST_SCREEN) {
            BasicListView()
        }
        composable(NavDirections.DETAILS_SCREEN) {
            DetailScreen()
        }
    }
}