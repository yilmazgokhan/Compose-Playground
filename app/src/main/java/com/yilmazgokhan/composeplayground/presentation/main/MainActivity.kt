package com.yilmazgokhan.composeplayground.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.yilmazgokhan.composeplayground.navigation.NavigationComponent

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
fun DetailScreen() {
    Text(text = "Detail")
}