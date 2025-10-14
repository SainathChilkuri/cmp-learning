package org.demo.cmp.project.presentation.screens.splash

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import org.demo.cmp.project.core.BasePage

class SplashScreen(splashViewModel: SplashViewModel) : BasePage<SplashViewModel>(viewModel = splashViewModel) {
    @Composable
    override fun Content(paddingValues: PaddingValues) {
        Text("SplashScreen")
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun TopAppBarUnit() {
    }
}