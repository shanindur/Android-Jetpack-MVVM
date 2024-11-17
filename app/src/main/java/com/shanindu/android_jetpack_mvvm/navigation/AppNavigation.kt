package com.shanindu.android_jetpack_mvvm.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shanindu.android_jetpack_mvvm.ui.LoginScreen
import com.shanindu.android_jetpack_mvvm.ui.MainScreen

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = NavigationItems.Login.route
    ) {
        // Navigation Screens
        composable(route = NavigationItems.Login.route) {
            LoginScreen(navController)
        }
        composable(route = NavigationItems.Main.route) {
            MainScreen()
        }

    }
}