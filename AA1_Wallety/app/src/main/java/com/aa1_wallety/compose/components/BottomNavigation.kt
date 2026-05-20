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
import androidx.compose.ui.res.stringResource
import com.aa1_wallety.R
import com.aa1_wallety.ui.theme.GrayText
import com.aa1_wallety.ui.theme.GreenPrimary
import com.aa1_wallety.ui.theme.White

@Composable
fun BottomNavigation(currentRoute: String, onNavigateToFamily: () -> Unit, onNavigateToHome: () -> Unit, onNavigateToLogin: () -> Unit = {}) {
    NavigationBar(containerColor = White) {
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = stringResource(id = R.string.nav_home)) },
            label = { Text(stringResource(id = R.string.nav_home)) },
            selected = currentRoute == "home",
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = GreenPrimary,
                selectedTextColor = GreenPrimary,
                indicatorColor = White
            ),
            onClick = onNavigateToHome
        )
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Filled.Group, contentDescription = stringResource(id = R.string.nav_family)) },
            label = { Text(stringResource(id = R.string.nav_family)) },
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
            icon = { Icon(imageVector = Icons.Filled.Person, contentDescription = stringResource(id = R.string.nav_account)) },
            label = { Text(stringResource(id = R.string.nav_account)) },
            selected = false,
            colors = NavigationBarItemDefaults.colors(
                unselectedIconColor = GrayText,
                unselectedTextColor = GrayText
            ),
            onClick = onNavigateToLogin
        )
    }
}