package com.example.loging1.ui.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.loging1.ui.screen.DetailView
import com.example.loging1.ui.screen.HomeScreen
import com.example.loging1.ui.screen.HomeView
import com.example.loging1.ui.screen.LoginScreen
import com.example.loging1.ui.screen.SplashScreen


@Composable
fun AppNavigation(modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController
        , startDestination = SplashScreen)
    {
        //Splash
        composable<SplashScreen>
        {
            SplashScreen(onNavigateNext = {
                val isLogged = false
                if(isLogged) {
                    navController.navigate(HomeScreen) {
                        popUpTo(SplashScreen) {
                            inclusive = true
                        }
                    }
                } else {
                    navController.navigate(LoginScreen){
                        popUpTo(SplashScreen){
                            inclusive = true
                        }
                    }
                }
            })
        }
        //Login
        composable<LoginScreen>(
            enterTransition = {fadeIn()},
            exitTransition = {fadeOut()}
        ){
            LoginScreen(onLoginSuccess = {
                navController.navigate(HomeScreen){
                    popUpTo(LoginScreen){
                        inclusive = true
                    }
                }
            })
        }
        //home
        composable<HomeScreen>(
            enterTransition = {fadeIn()},
            exitTransition = {fadeOut()}
        ){
            HomeScreen(onLogout = {
                navController.navigate(LoginScreen){
                    popUpTo(HomeScreen){
                        inclusive = true
                    }
                }
            })
        }
    }

}