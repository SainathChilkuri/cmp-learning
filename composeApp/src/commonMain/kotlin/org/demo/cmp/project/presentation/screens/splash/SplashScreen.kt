package org.demo.cmp.project.presentation.screens.splash

import AppColors
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import demo_cmp_project.composeapp.generated.resources.Res
import demo_cmp_project.composeapp.generated.resources.amico
import demo_cmp_project.composeapp.generated.resources.confused_about_managing_time
import demo_cmp_project.composeapp.generated.resources.enjoy_your_time
import org.demo.cmp.project.core.AppLogs
import org.demo.cmp.project.core.BasePage
import org.demo.cmp.project.core.DataState
import org.demo.cmp.project.design_system.AppText
import org.demo.cmp.project.design_system.GoogleSignIn
import org.demo.cmp.project.design_system.VerticalSpacer
import org.demo.cmp.project.presentation.navigations.NavigatorUtil
import org.demo.cmp.project.presentation.navigations.Screens
import org.demo.cmp.project.utils.SafeArea
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

class SplashScreen(splashViewModel: SplashViewModel) : BasePage<SplashViewModel>(viewModel = splashViewModel) {

    @Composable
    override fun Content(paddingValues: PaddingValues, viewModel: SplashViewModel) {
        val stateValue = viewModel.navigateToLogin.collectAsState()
            if(stateValue.value.dataState == DataState.SUCCESS) {
                NavigatorUtil.PushNamedAndRemoveUntil(Screens.Dashboard, Screens.Splash)
            }
            if(stateValue.value.dataState == DataState.FAILED) {
                NavigatorUtil.PushNamedAndRemoveUntil(Screens.Login, Screens.Splash)
            }
        SafeArea { modifier ->
            Box(
                modifier = modifier.fillMaxSize().background(color = AppColors.white),
                contentAlignment = Alignment.Center
            ) {
                Column (
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Image(
                        painter = painterResource(Res.drawable.amico),
                        contentDescription = "Splash Image",
                        modifier = Modifier.height(300.dp).fillMaxWidth()
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun TopAppBarUnit() {
    }
}