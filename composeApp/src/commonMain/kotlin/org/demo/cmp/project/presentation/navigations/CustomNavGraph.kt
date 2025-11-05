package org.demo.cmp.project.presentation.navigations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.demo.cmp.project.presentation.screens.dashboard.DashboardScreen
import org.demo.cmp.project.presentation.screens.login.LoginScreen
import org.demo.cmp.project.presentation.screens.login.LoginViewModel
import org.demo.cmp.project.presentation.screens.splash.SplashScreen
import org.demo.cmp.project.presentation.screens.splash.SplashViewModel
import org.koin.core.Koin

@Composable
fun CustomNavGraph(navController: NavHostController, koin: Koin) {
  CompositionLocalProvider(Navigator provides navController) {
      NavHost(navController = navController, startDestination = Screens.Splash.route) {
          composable(Screens.Splash.route) {
              SplashScreen(splashViewModel = koin.get()).Draw()
          }

          composable(Screens.Login.route) {
              LoginScreen(loginViewModel = koin.get()).Draw()
          }

          composable(Screens.Dashboard.route) {
              DashboardScreen(dashboardViewModel = koin.get()).Draw()
          }
      }
  }
}