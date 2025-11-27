package com.get.set.auth.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.get.set.coremodels.models.UserDataModel
import com.get.set.coremodule.BasePage
import com.get.set.coremodule.DataState
import com.get.set.coremodule.navigations.NavigatorUtil
import com.get.set.coremodule.navigations.Screens
import com.get.set.designsystem.components.AppText
import com.get.set.designsystem.components.NameInitialWidget
import com.get.set.designsystem.components.VerticalSpacer
import com.get.set.designsystem.util.AppColors
import getInitial
import kotlinx.coroutines.launch

class ProfileScreen(
    private val profileViewModel: ProfileViewModel,
    private val userDataModel: UserDataModel
) : BasePage<ProfileViewModel>(profileViewModel) {

    @Composable
    override fun Content(paddingValues: PaddingValues, viewModel: ProfileViewModel) {
        val profileScreenState = viewModel.profileScreenStateValue.collectAsState()

        val scope = rememberCoroutineScope();

        if(profileScreenState.value.dataState == DataState.SUCCESS) {
            NavigatorUtil.pushNamedAndRemoveUntil(Screens.Login,null)
        }

        Column(
            modifier = Modifier.fillMaxHeight().fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NameInitialWidget((userDataModel.displayName ?: "").getInitial())
            VerticalSpacer(30)
            AppText(userDataModel.displayName ?: "", size = 24, fontWeight = FontWeight.W600)
            AppText(userDataModel.email ?: "", size = 14, fontWeight = FontWeight.W300)
            VerticalSpacer(20)
            when(profileScreenState.value.dataState) {
                DataState.LOADING -> {
                    CircularProgressIndicator()
                }
                else -> {
                    Box(
                        modifier = Modifier.background(color = Color.Red, shape = RoundedCornerShape(10.dp)).clickable {
                            scope.launch {
                                viewModel.logoutUser()
                            }
                        }
                    ) {
                        Row(
                            modifier = Modifier.padding(vertical = 15.dp, horizontal = 10.dp)
                        ) {
                            AppText("Logout", color = AppColors.white, size = 14)
                            Box(modifier = Modifier.width(10.dp))
                            Icon(
                                imageVector = Icons.AutoMirrored.Default.ExitToApp,
                                contentDescription = "Exit"
                            )
                        }
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun TopAppBarUnit() {
        CenterAlignedTopAppBar(
            title = {
                AppText(
                    "Profile",
                    size = 18,
                    fontWeight = FontWeight.W800,
                )
            },
            colors = TopAppBarDefaults.topAppBarColors().copy(containerColor = Color.Transparent)
        )
    }
}