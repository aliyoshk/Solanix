package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.CustomerScreenScreen
import com.example.myapplication.ProfileScreen
import com.example.myapplication.WelcomeScreen
import com.example.myapplication.navigation.AppNavRoutes.WELCOME

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = WELCOME
    ) {
        composable(WELCOME) {
            WelcomeScreen(
                onClick = { navController.navigate(AppNavRoutes.PROFILE) }
            )
        }
        composable(AppNavRoutes.PROFILE) {
            ProfileScreen(navController)
        }
        composable(
            route = AppNavRoutes.CUSTOMER_SCREEN,
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("age") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            val age = backStackEntry.arguments?.getString("age")
            CustomerScreenScreen(name = name, age = age)
        }
    }
}

object AppNavRoutes {
    const val WELCOME = "welcome"
    const val PROFILE = "profile"
    const val CUSTOMER_SCREEN = "customer_screen/{name}/{age}"
}