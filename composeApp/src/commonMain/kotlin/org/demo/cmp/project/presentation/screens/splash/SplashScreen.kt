package org.demo.cmp.project.presentation.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import demo_cmp_project.composeapp.generated.resources.Res
import com.get.set.coremodule.BasePage
import com.get.set.coremodule.DataState
import com.get.set.coremodule.navigations.NavigatorUtil
import com.get.set.coremodule.navigations.Screens
import com.get.set.designsystem.util.AppColors
import com.get.set.designsystem.util.DSAsset
import com.get.set.designsystem.util.SafeArea
import org.jetbrains.compose.resources.painterResource

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
                        painter = painterResource(DSAsset.amico),
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