package com.shanindu.android_jetpack_mvvm.navigation

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.shanindu.android_jetpack_mvvm.ui.DetailsScreen
import com.shanindu.android_jetpack_mvvm.ui.HomeScreen
import com.shanindu.android_jetpack_mvvm.ui.PostScreen
import com.shanindu.android_jetpack_mvvm.ui.ProfileScreen
import com.shanindu.android_jetpack_mvvm.viewmodel.PostViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavigation() {
    val navController = rememberNavController()

    Scaffold(bottomBar = {
        BottomNavigationBar(navHostController = navController)
    }) { innerPadding ->

        NavHost(
            navController = navController, startDestination = NavigationItems.Home.route
        ) {
            // Bottom Navigation Screens
            composable(route = NavigationItems.Home.route) {
                HomeScreen()
            }
            composable(route = NavigationItems.Post.route) {

                PostScreen(postViewModel = PostViewModel())
            }
            composable(route = NavigationItems.Profile.route) {
                ProfileScreen()
            }

            // Inner Screens
            composable(
                route = "details/{itemId}",
                arguments = listOf(navArgument("itemId") { defaultValue = "Default Item" })
            ) { backStackEntry ->
                val itemId = backStackEntry.arguments?.getString("itemId") ?: "Default Item"
                DetailsScreen(itemId = itemId)
            }

        }
    }
}