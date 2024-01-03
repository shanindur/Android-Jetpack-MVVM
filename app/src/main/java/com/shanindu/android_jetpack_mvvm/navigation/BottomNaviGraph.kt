package com.shanindu.android_jetpack_mvvm.navigation

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shanindu.android_jetpack_mvvm.view.BottomBarScreen
import com.shanindu.android_jetpack_mvvm.view.CreditCardScreen
import com.shanindu.android_jetpack_mvvm.view.HomeScreen
import com.shanindu.android_jetpack_mvvm.view.ProfileScreen
import com.shanindu.android_jetpack_mvvm.viewmodel.CreditCardViewModel

@Composable
fun BottomNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Card.route) {

            CreditCardScreen(viewModel = CreditCardViewModel())
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }

    }
}