package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.myapplication.CustomerScreenScreen
import com.example.myapplication.HomeScreen
import com.example.myapplication.LoginScreen
import com.example.myapplication.ProfileScreen
import com.example.myapplication.WelcomeScreen
import kotlinx.serialization.Serializable


@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    isUserLoggedIn: Boolean = false
) {
    NavHost(
        navController = navController,
        startDestination = if (isUserLoggedIn) HomeScreen else LoginScreen
    ) {
        composable<WelcomeScreen> {
            WelcomeScreen(
                onClick = { navController.navigate(ProfileScreen) }
            )
        }
        composable<ProfileScreen> {
            ProfileScreen(navigation = navController)
        }
        composable<CustomerScreen> {
            val args = it.toRoute<CustomerScreen>()
            CustomerScreenScreen(name = args.name, age = args.age)
        }
        composable<LoginScreen> {
            LoginScreen(navController = navController)
        }
        composable<HomeScreen> {
            HomeScreen()
        }
    }
}




@Serializable
object WelcomeScreen

@Serializable
object ProfileScreen

@Serializable
data class CustomerScreen(
    val name: String,
    val age: String,
    val balance: Double? = null,
    val isActive: Boolean? = null
)

@Serializable
object LoginScreen

@Serializable
object HomeScreen