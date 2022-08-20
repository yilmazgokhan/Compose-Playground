package com.yilmazgokhan.composeplayground.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yilmazgokhan.composeplayground.presentation.home.HomeScreen
import com.yilmazgokhan.composeplayground.presentation.list.BasicListView
import com.yilmazgokhan.composeplayground.presentation.login.LoginScreen
import com.yilmazgokhan.composeplayground.utils.NavDirections

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Scaffold {
                NavigationComponent(navController)
            }
        }
    }
}

@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavDirections.LOGIN_SCREEN
    ) {
        composable(NavDirections.LOGIN_SCREEN) {
            LoginScreen(navController)
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

@Composable
fun DetailScreen() {
    Text(text = "Detail")
}