package com.yilmazgokhan.composeplayground.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
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
import com.yilmazgokhan.composeplayground.presentation.list.BasicListScreen
import com.yilmazgokhan.composeplayground.presentation.login.LoginScreen
import com.yilmazgokhan.composeplayground.presentation.message.MessageScreen
import com.yilmazgokhan.composeplayground.presentation.register.RegisterScreen
import com.yilmazgokhan.composeplayground.ui.component.BottomBar
import com.yilmazgokhan.composeplayground.ui.component.DefaultScaffold

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph(startDestination: String = NavDirections.Home.route) {
    val navController = rememberAnimatedNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    DefaultScaffold(
        bottomBar = {
            /*
            BottomNav.values().forEach { navItem ->
                if (navItem.route == currentRoute) {
                    BottomBar(
                        navController = navController,
                        currentRoute = currentRoute
                    )
                }
            }
             */
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
                    },
                    navigateToBack = {
                        navController.popBackStack()
                    }
                )
            }
            composable(NavDirections.Home.route) {
                HomeScreen(
                    hiltViewModel(),
                    navigateToLogin = {
                        navController.navigate(NavDirections.Login.route)
                    },
                    navigateToRegister = {
                        navController.navigate(NavDirections.Register.route)
                    },
                    navigateToList = {
                        navController.navigate(NavDirections.BasicList.route)
                    },
                    navigateToDetails = {

                    },
                    navigateToMessages = {
                        navController.navigate(NavDirections.Message.route)
                    }
                )
            }
            composable(NavDirections.Register.route) {
                RegisterScreen(
                    hiltViewModel(),
                    navigateToBack = {
                        navController.popBackStack()
                    }
                )
            }
            composable(
                NavDirections.BasicList.route, content = {
                    BasicListScreen(
                        hiltViewModel(),
                        navigateToBack = {
                            navController.popBackStack()
                        },
                        navigateToDetail = {
                            navController.navigate(NavDirections.Details.route.plus("?detail=$it"))
                        })
                },
                enterTransition = {
                    slideIntoContainer(
                        AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween(700)
                    )
                },
                popExitTransition = {
                    slideOutOfContainer(
                        AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween(700)
                    )
                }
            )
            composable(
                NavDirections.Message.route, content = {
                    MessageScreen(
                        hiltViewModel(),
                        navigateToBack = {
                            navController.popBackStack()
                        })
                },
                enterTransition = {
                    slideIntoContainer(
                        AnimatedContentScope.SlideDirection.Left,
                        animationSpec = tween(700)
                    )
                },
                popExitTransition = {
                    slideOutOfContainer(
                        AnimatedContentScope.SlideDirection.Right,
                        animationSpec = tween(700)
                    )
                }
            )
        }
    }
}