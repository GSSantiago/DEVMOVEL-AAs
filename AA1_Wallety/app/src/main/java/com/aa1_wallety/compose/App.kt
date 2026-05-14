package com.aa1_wallety.compose

import android.annotation.SuppressLint
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// TODO: Remover mock
@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun WalletyApp() {
    val navController = rememberNavController()
    val viewModel = WalletyViewModel()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onNavigateToHome = { navController.navigate("home") }
            )
        }
        composable("home") {
            Text("Home Screen")
        }
        composable("family") {
            Text("Family Screen")
        }
    }
}