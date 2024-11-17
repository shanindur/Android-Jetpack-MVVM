package com.shanindu.android_jetpack_mvvm.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItems(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    //App navigation
    object Login : NavigationItems(
        route = "login",
        title = "Login",
        icon = Icons.Default.Home
    )

    object Main : NavigationItems(
        route = "main",
        title = "Main",
        icon = Icons.Default.Home
    )

    //Bottom navigation
    object Home : NavigationItems(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Post : NavigationItems(
        route = "posts",
        title = "Posts",
        icon = Icons.Default.Menu
    )

    object Profile : NavigationItems(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}