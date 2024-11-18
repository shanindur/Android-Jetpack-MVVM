package com.shanindu.android_jetpack_mvvm.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.shanindu.android_jetpack_mvvm.ui.DetailsScreen
import com.shanindu.android_jetpack_mvvm.ui.HomeScreen
import com.shanindu.android_jetpack_mvvm.ui.LoginScreen
import com.shanindu.android_jetpack_mvvm.ui.PostScreen
import com.shanindu.android_jetpack_mvvm.ui.ProfileScreen
import com.shanindu.android_jetpack_mvvm.viewmodel.PostViewModel

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            val currentBackStackEntry = navController.currentBackStackEntryAsState()
            val currentDestination = currentBackStackEntry.value?.destination?.route

            if (currentDestination in listOf("home", "posts", "profile")) {
                BottomNavigationBar(navController = navController)
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = "login"
            ) {
                composable(NavigationItems.Login.route) { LoginScreen(navController) }
                composable(NavigationItems.Home.route) { HomeScreen() }
                composable(NavigationItems.Post.route) { PostScreen(PostViewModel(), navController) }
                composable(NavigationItems.Profile.route) { ProfileScreen() }
                composable(
                    route = NavigationItems.Details.route,
                    arguments = listOf(navArgument("itemId") { defaultValue = "Default Item" })
                ) { backStackEntry ->
                    val itemId = backStackEntry.arguments?.getString("itemId") ?: "Default Item"
                    DetailsScreen(itemId = itemId)
                }
            }
        }
    }


}


