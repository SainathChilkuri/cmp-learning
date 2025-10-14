package org.demo.cmp.project.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import org.demo.cmp.project.presentation.navigations.CustomNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController();
        CustomNavGraph(navController)
    }
}
