package com.get.set.taskmanagement.presentation.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.get.set.coremodels.models.UserDataModel
import com.get.set.coremodule.BasePage
import com.get.set.taskmanagement.presentation.bottom_nav_bar.AppBottomNavigationBar
import com.get.set.taskmanagement.presentation.bottom_nav_bar.BottomNavBarViewModel

class DashboardScreen(private val dashboardViewModel: DashboardViewModel, private val userDataModel: UserDataModel, private val bottomNavBarViewModel: BottomNavBarViewModel): BasePage<DashboardViewModel>(viewModel = dashboardViewModel) {

    @Composable
    override fun Content(paddingValues: PaddingValues, viewModel: DashboardViewModel) {
           Box(
               contentAlignment = Alignment.Center
           ) {
               Column(
                   modifier = Modifier.fillMaxSize(),
                   verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.CenterHorizontally
               ) {
                   Text("Dashboard ${userDataModel.displayName}")
               }
           }
    }

    @Composable
    override fun BottomNavBar() {
           AppBottomNavigationBar(bottomNavBarViewModel).Content(PaddingValues(),bottomNavBarViewModel)
    }
}