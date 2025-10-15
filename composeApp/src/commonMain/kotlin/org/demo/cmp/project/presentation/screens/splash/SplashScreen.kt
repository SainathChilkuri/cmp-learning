package org.demo.cmp.project.presentation.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import demo_cmp_project.composeapp.generated.resources.Res
import demo_cmp_project.composeapp.generated.resources.cmp_learnings
import demo_cmp_project.composeapp.generated.resources.welcome_to
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.demo.cmp.project.core.BasePage
import org.demo.cmp.project.presentation.navigations.NavigatorUtil
import org.demo.cmp.project.presentation.navigations.Screens
import org.jetbrains.compose.resources.stringResource

class SplashScreen(splashViewModel: SplashViewModel) : BasePage<SplashViewModel>(viewModel = splashViewModel) {

    @Composable
    override fun Content(paddingValues: PaddingValues, viewModel: SplashViewModel) {
        val stateValue by viewModel.navigateToLogin.collectAsState()
        if (stateValue) {
            NavigatorUtil.PushNamedAndRemoveUntil(Screens.Login, Screens.Splash)
        }
        Box(
            modifier = Modifier.fillMaxSize().background(color = Color(0xFFB3E5FC)),
            contentAlignment = Alignment.Center
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(stringResource(Res.string.welcome_to), fontSize = 20.sp, fontWeight = FontWeight.W800)
                Text(stringResource(Res.string.cmp_learnings), fontSize = 20.sp, fontWeight = FontWeight.W800)
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun TopAppBarUnit() {
    }
}