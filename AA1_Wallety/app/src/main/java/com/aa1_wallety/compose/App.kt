package com.aa1_wallety.compose

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun WalletyApp() {
    val navController = rememberNavController()
    val viewModel: WalletyViewModel = viewModel(factory = AppViewModelProvider.Factory)

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onNavigateToHome = { navController.navigate("home") }
            )
        }
        composable("home") {
            HomeScreen(
                viewModel = viewModel,
                onNavigateToFamily = { navController.navigate("family") },
                onNavigateToLogin = { navController.navigate("login") }

            )
        }
        composable("family") {
            FamilyScreen(
                viewModel = viewModel,
                onNavigateToHome = { navController.navigate("home")},
                onNavigateToLogin = { navController.navigate("login") }
            )
        }
    }
}