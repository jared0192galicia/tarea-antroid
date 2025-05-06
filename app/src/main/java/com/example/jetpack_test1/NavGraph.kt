package com.example.jetpack_test1

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "A") {
        composable (route = "A"){
            ScreenA(navController)
        }
        composable ("B/{from}"){navBackStackEntry ->
            /* Extracting the id from the route */
            val cad = navBackStackEntry.arguments?.getString("from")
            /* We check if it's not null */
            cad?.let { cadena->
                ScreenB(navController, cadena)
            }
        }
        composable (route = "C"){
            ScreenC(navController)
        }
    }
}