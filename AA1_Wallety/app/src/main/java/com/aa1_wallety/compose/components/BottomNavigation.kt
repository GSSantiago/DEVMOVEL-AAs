package com.aa1_wallety.compose.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.aa1_wallety.ui.theme.GrayText
import com.aa1_wallety.ui.theme.GreenPrimary
import com.aa1_wallety.ui.theme.White

@Composable
fun BottomNavigation(currentRoute: String, onNavigateToFamily: () -> Unit, onNavigateToHome: () -> Unit, onNavigateToLogin: () -> Unit = {}) {
    NavigationBar(containerColor = White) {
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = currentRoute == "home",
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = GreenPrimary,
                selectedTextColor = GreenPrimary,
                indicatorColor = White
            ),
            onClick = onNavigateToHome
        )
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Filled.Group, contentDescription = "Família") },
            label = { Text("Família") },
            selected = currentRoute == "family",
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = GreenPrimary,
                selectedTextColor = GreenPrimary,
                indicatorColor = White,
                unselectedIconColor = GrayText,
                unselectedTextColor = GrayText
            ),
            onClick = onNavigateToFamily
        )
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Filled.Person, contentDescription = "Conta") },
            label = { Text("Conta") },
            selected = false,
            colors = NavigationBarItemDefaults.colors(
                unselectedIconColor = GrayText,
                unselectedTextColor = GrayText
            ),
            onClick = onNavigateToLogin
        )
    }
}