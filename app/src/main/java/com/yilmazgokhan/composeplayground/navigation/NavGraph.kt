package com.yilmazgokhan.composeplayground.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.yilmazgokhan.composeplayground.presentation.home.HomeScreen
import com.yilmazgokhan.composeplayground.presentation.login.LoginScreen
import com.yilmazgokhan.composeplayground.presentation.register.RegisterScreen
import com.yilmazgokhan.composeplayground.ui.component.BottomBar
import com.yilmazgokhan.composeplayground.ui.component.DefaultScaffold

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph(startDestination: String = NavDirections.Login.route) {
    val navController = rememberAnimatedNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    DefaultScaffold(
        bottomBar = {
            BottomNav.values().forEach { navItem ->
                if (navItem.route == currentRoute) {
                    BottomBar(
                        navController = navController,
                        currentRoute = currentRoute
                    )
                }
            }
        },
    ) { innerPadding ->
        AnimatedNavHost(
            navController = navController,
            startDestination = startDestination,
            Modifier.padding(innerPadding)
        ) {
            composable(NavDirections.Login.route) {
                LoginScreen(
                    hiltViewModel(),
                    navigateToRegister = {
                        navController.navigate(NavDirections.Register.route)
                    },
                    navigateToHome = {
                        navController.navigate(NavDirections.Home.route)
                    }
                )
            }
            composable(NavDirections.Home.route) {
                HomeScreen(
                    hiltViewModel(),
                )
            }
            composable(NavDirections.Register.route) {
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
            composable(NavDirections.DETAILS_Directions.route) {
                DetailScreen(
                    //hiltViewModel()
                )
            }
             */
        }
    }
}