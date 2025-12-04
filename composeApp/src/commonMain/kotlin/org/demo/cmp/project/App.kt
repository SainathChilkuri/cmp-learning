package org.demo.cmp.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.get.set.coremodule.AppLogs
import com.get.set.coremodule.navigations.Screens
import org.demo.cmp.project.presentation.navigations.CustomNavGraph
import org.demo.cmp.project.presentation.screens.splash.SplashScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.mp.KoinPlatform.getKoin

@Composable
@Preview
fun App() {
    AppLogs.info("Starting the app", tag = "APP");
    MaterialTheme {
        val koin = getKoin()
        val navController = mutableStateListOf<Screens>(Screens.Splash)
        CustomNavGraph(navController,koin)
    }
}
