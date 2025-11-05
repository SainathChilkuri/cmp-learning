package org.demo.cmp.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import org.demo.cmp.project.core.AppLogs
import org.demo.cmp.project.presentation.navigations.CustomNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.mp.KoinPlatform.getKoin

@Composable
@Preview
fun App() {
    AppLogs.info("Starting the app", tag = "APP");
    MaterialTheme {
        val koin = getKoin()
        val navController = rememberNavController();
        CustomNavGraph(navController,koin)
    }
}
