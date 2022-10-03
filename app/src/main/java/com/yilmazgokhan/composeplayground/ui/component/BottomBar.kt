package com.yilmazgokhan.composeplayground.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.yilmazgokhan.composeplayground.navigation.BottomNav

@Composable
fun BottomBar(
    navController: NavController,
    currentRoute: String?
) {
    BottomAppBar(
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.onSecondary
    ) {
        BottomNav.values().forEach { screen ->
            BottomNavigationItem(
                selectedContentColor = Color.White,
                unselectedContentColor = MaterialTheme.colors.secondary,
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = screen.iconId),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },

                label = {
                    Text(
                        text = screen.screenName,
                        style = MaterialTheme.typography.overline,
                        textAlign = TextAlign.Center
                    )
                },
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute == screen.route) {
                        return@BottomNavigationItem
                    }

                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}

