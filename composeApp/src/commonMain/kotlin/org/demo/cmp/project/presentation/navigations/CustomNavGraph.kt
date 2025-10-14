package org.demo.cmp.project.presentation.navigations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.demo.cmp.project.presentation.screens.splash.SplashScreen
import org.demo.cmp.project.presentation.screens.splash.SplashViewModel

@Composable
fun CustomNavGraph(navController: NavHostController) {
  CompositionLocalProvider(Navigator provides navController) {
      NavHost(navController = navController, startDestination = Screens.Splash.route) {
          composable(Screens.Splash.route) {
              SplashScreen(splashViewModel = SplashViewModel()).Draw()
          }
      }
  }
}