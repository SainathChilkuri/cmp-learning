package com.get.set.taskmanagement.presentation.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.get.set.coremodels.models.UserDataModel
import com.get.set.coremodule.BasePage
import com.get.set.taskmanagement.presentation.bottom_nav_bar.AppBottomNavigationBar
import com.get.set.taskmanagement.presentation.bottom_nav_bar.BottomNavBarViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class DashboardScreen(private val dashboardViewModel: DashboardViewModel, private val userDataModel: UserDataModel, private val bottomNavBarViewModel: BottomNavBarViewModel): BasePage<DashboardViewModel>(viewModel = dashboardViewModel) {

    @Composable
    override fun Content(paddingValues: PaddingValues, viewModel: DashboardViewModel) {
        pagerState = rememberPagerState(initialPage = 0, pageCount = {
              4
         })

           Box(
               contentAlignment = Alignment.Center
           ) {
               HorizontalPager(
                   pageSize = PageSize.Fill,
                   state = pagerState
               ) { page ->
                   when (page) {
                       0 -> Text("Dashboard")
                       1 -> Text("Calendar")
                       2 -> Text("Book")
                       3 -> Text("Profile")
                   }
               }
           }
    }

    @Composable
    override fun BottomNavBar() {
        val scope = rememberCoroutineScope();
           AppBottomNavigationBar(bottomNavBarViewModel) {
              scope.launch {
                  dashboardViewModel.updatePagerState(pagerState,it)
              }
           }.Content(PaddingValues(),bottomNavBarViewModel)
    }
}