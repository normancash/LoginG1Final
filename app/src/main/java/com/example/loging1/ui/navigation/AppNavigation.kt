package com.example.loging1.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.loging1.ui.screen.DetailView
import com.example.loging1.ui.screen.HomeView


@Composable
fun AppNavigation(modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeScreen,
        modifier = modifier.fillMaxSize()
    ){
        composable<HomeScreen>{
            HomeView(
                onNavigationToDetail = {
                    id -> navController.navigate(DetailScreen(id))
                }
            )
        }
        composable<DetailScreen>{
            backStackEntry ->
            val args = backStackEntry.toRoute<DetailScreen>()
            DetailView(
                userId = args.userId,
                onBack = {navController.popBackStack()}
            )
        }
    }

}