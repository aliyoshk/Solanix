package com.example.myapplication.deleted.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.myapplication.deleted.CustomerScreenScreen
import com.example.myapplication.deleted.HomeScreen
import com.example.myapplication.deleted.onboarding.LoginScreen
import com.example.myapplication.deleted.ProfileScreen
import com.example.myapplication.deleted.onboarding.RegistrationScreen
import com.example.myapplication.deleted.WelcomeScreen
import com.example.myapplication.deleted.onboarding.RegisteredUsersScreen
import kotlinx.serialization.Serializable


@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    isUserLoggedIn: Boolean = false
) {
    NavHost(
        navController = navController,
        startDestination = RegistrationScreen
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
        composable<RegistrationScreen> {
            RegistrationScreen(navController = navController)
        }
        composable<RegisteredUsersScreen> {
            RegisteredUsersScreen(navController = navController)
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

@Serializable
object RegistrationScreen

@Serializable
object RegisteredUsersScreen