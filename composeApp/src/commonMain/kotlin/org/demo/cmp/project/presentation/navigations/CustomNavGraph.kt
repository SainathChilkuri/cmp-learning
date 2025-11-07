package org.demo.cmp.project.presentation.navigations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.get.set.coremodule.navigations.Navigator
import com.get.set.coremodule.navigations.Screens
import org.demo.cmp.project.presentation.screens.dashboard.DashboardScreen
import com.get.set.auth.presentation.login.LoginScreen
import org.demo.cmp.project.presentation.screens.splash.SplashScreen
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