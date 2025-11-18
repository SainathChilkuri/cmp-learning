package com.get.set.taskmanagement.presentation.bottom_bar_page_view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.get.set.coremodels.models.UserDataModel
import com.get.set.coremodule.BasePage
import com.get.set.taskmanagement.presentation.bottom_nav_bar.AppBottomNavigationBar
import com.get.set.taskmanagement.presentation.bottom_nav_bar.BottomNavBarViewModel
import com.get.set.taskmanagement.presentation.dashboard.DashboardScreen
import com.get.set.taskmanagement.presentation.dashboard.DashboardScreenParams
import kotlinx.coroutines.launch

class BottomBarPageView(private val bottomBarPageViewModel: BottomBarPageViewModel, private val userDataModel: UserDataModel, private val bottomNavBarViewModel: BottomNavBarViewModel): BasePage<BottomBarPageViewModel>(viewModel = bottomBarPageViewModel) {

    @Composable
    override fun Content(paddingValues: PaddingValues, viewModel: BottomBarPageViewModel) {
            pagerState = rememberPagerState(initialPage = 0, pageCount = {
              4
            })

           Box(
               contentAlignment = Alignment.Center,
               modifier = Modifier.fillMaxWidth().fillMaxHeight()
           ) {
               HorizontalPager(
                   userScrollEnabled = false,
                   pageSize = PageSize.Fill,
                   state = pagerState,
                   modifier = Modifier.align(Alignment.Center)
               ) { page ->
                   when (page) {
                       0 ->  DashboardScreen(viewModel.dashboardViewModel, DashboardScreenParams(userDataModel)).Draw()
                       1 -> Scaffold {
                           Text("Calendar")
                       }
                       2 -> Text("Book")
                       3 -> Text("Profile")
                   }
               }
           }
    }

    @Composable
    override fun BottomNavBar() {
           val scope = rememberCoroutineScope();
           AppBottomNavigationBar(bottomNavBarViewModel, userDataModel) {
              scope.launch {
                  bottomBarPageViewModel.updatePagerState(pagerState,it)
              }
           }.Content(PaddingValues(),bottomNavBarViewModel)
    }
}