package com.shanindu.android_jetpack_mvvm.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val screens = listOf(
        NavigationItems.Home, NavigationItems.Post, NavigationItems.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach { screen ->
            BottomNavigationItem(selected = currentDestination?.hierarchy?.any {
                it.route == screen.route
            } == true,
                onClick = { navController.navigate(screen.route) },
                icon = { Icon(imageVector = screen.icon, contentDescription = null) },
                label = { Text(screen.title) })
        }
    }
}
