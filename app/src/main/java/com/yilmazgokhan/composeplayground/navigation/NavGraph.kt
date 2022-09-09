package com.yilmazgokhan.composeplayground.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.yilmazgokhan.composeplayground.presentation.login.LoginScreen
import com.yilmazgokhan.composeplayground.presentation.main.DetailScreen
import com.yilmazgokhan.composeplayground.presentation.register.RegisterScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph(startDestination: String = NavScreen.LOGIN_SCREEN.route) {
    val navController = rememberAnimatedNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold { innerPadding ->
        AnimatedNavHost(
            navController = navController,
            startDestination = startDestination,
            Modifier.padding(innerPadding)
        ) {
            composable(NavScreen.LOGIN_SCREEN.route) {
                LoginScreen(
                    hiltViewModel(),
                    navigateToRegister = {
                        navController.navigate(NavScreen.REGISTER_SCREEN.route)
                    },
                    navigateToHome = {
                        navController.navigate(NavScreen.HOME_SCREEN.route)
                    }
                )
            }
            composable(NavScreen.REGISTER_SCREEN.route) {
                RegisterScreen(
                    hiltViewModel(),
                    navigateToBack = {
                        navController.popBackStack()
                    }
                    /*
                    navigateToHome = {
                        navController.navigate(NavScreen.HOME_SCREEN.route)
                    }
                     */
                )
            }
            /*
            composable(NavScreen.BASIC_LIST_SCREEN.route) {
                BasicListView(
                    hiltViewModel(),
                    navigateToDetail = {
                        navController.navigate(NavScreen.CharacterDetail.route.plus("?characterDetail=${it.toJson()}"))
                    }
                )
            }
             */

            composable(NavScreen.DETAILS_SCREEN.route) {
                DetailScreen(
                    //hiltViewModel()
                )
            }
        }
    }
}