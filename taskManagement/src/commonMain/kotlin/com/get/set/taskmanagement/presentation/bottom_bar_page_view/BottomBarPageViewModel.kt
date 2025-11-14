package com.get.set.taskmanagement.presentation.bottom_bar_page_view

import androidx.compose.foundation.pager.PagerState
import com.get.set.coremodule.AppLogs
import com.get.set.coremodule.BaseViewModel
import com.get.set.taskmanagement.presentation.dashboard.DashboardViewModel

class BottomBarPageViewModel (val dashboardViewModel: DashboardViewModel): BaseViewModel() {

    suspend fun updatePagerState(pagerState: PagerState, tabPosition: Int) {
        AppLogs.info("to ${tabPosition}","Tabs")
                pagerState.animateScrollToPage(tabPosition)
    }
}