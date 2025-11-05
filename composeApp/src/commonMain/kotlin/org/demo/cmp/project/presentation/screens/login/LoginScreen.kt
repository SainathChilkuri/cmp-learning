package org.demo.cmp.project.presentation.screens.login

import AppColors
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import demo_cmp_project.composeapp.generated.resources.Res
import demo_cmp_project.composeapp.generated.resources.amico
import demo_cmp_project.composeapp.generated.resources.confused_about_managing_time
import demo_cmp_project.composeapp.generated.resources.enjoy_your_time
import kotlinx.coroutines.launch
import org.demo.cmp.project.core.AppLogs
import org.demo.cmp.project.core.BasePage
import org.demo.cmp.project.data.GoogleSignInUtil
import org.demo.cmp.project.design_system.AppText
import org.demo.cmp.project.design_system.GoogleSignIn
import org.demo.cmp.project.design_system.VerticalSpacer
import org.demo.cmp.project.utils.SafeArea
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

class LoginScreen (private val loginViewModel: LoginViewModel ): BasePage<LoginViewModel>(viewModel = loginViewModel ) {

    @Composable
    override fun Content(paddingValues: PaddingValues, viewModel: LoginViewModel) {
        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        SafeArea { modifier ->
            Box(
                modifier = modifier.fillMaxSize().background(color = AppColors.white),
                contentAlignment = Alignment.Center
            ) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ){
                    VerticalSpacer(200)
                    Image(
                        painter = painterResource(Res.drawable.amico),
                        contentDescription = "Splash Image",
                        modifier = Modifier.height(300.dp).fillMaxWidth()
                    )
                    VerticalSpacer(20)
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    ) {
                        AppText(stringResource(Res.string.enjoy_your_time), size = 32, fontWeight = FontWeight.W700, color = AppColors.onyxBlack,)
                        VerticalSpacer(15)
                        AppText(stringResource(Res.string.confused_about_managing_time), size = 14, fontWeight = FontWeight.W400,color = AppColors.grey, textAlign = TextAlign.Center)
                    }
                    Spacer(modifier = Modifier.weight(1f)) // Pushes the button to the bottom
                    GoogleSignIn(onClick = {
                        AppLogs.info("Google Sign In Initiated", tag = "Google Sign In")
                        viewModel.viewModelScope.launch {
                            val accountData = GoogleSignInUtil.signIn()
                            AppLogs.info(accountData?.email ?: "Empty" ,"GoogleAccountData")
                            AppLogs.info(accountData?.displayName ?: "Empty" ,"GoogleAccountData")
                        }
                    })
                    VerticalSpacer(40)
                }
            }
        }
    }

}