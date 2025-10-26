package com.example.jetpack_test1

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun Nav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "A") {
        composable (route = "A"){
            Form(navController)
        }
        composable ("B"){navBackStackEntry ->
            ScreenB(navController)
        }
        composable (route = "C"){
            ScreenC(navController)
        }
    }
}
