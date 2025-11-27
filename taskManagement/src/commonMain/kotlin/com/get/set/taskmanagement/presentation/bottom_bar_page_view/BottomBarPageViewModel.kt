package com.get.set.taskmanagement.presentation.bottom_bar_page_view

import androidx.compose.foundation.pager.PagerState
import com.get.set.auth.presentation.profile.ProfileViewModel
import com.get.set.coremodule.BaseViewModel
import com.get.set.taskmanagement.presentation.calendar.CalendarViewModel
import com.get.set.taskmanagement.presentation.dashboard.DashboardViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class BottomBarPageViewModel(
    val dashboardViewModel: DashboardViewModel,
    val calendarViewModel: CalendarViewModel,
    val profileViewModel: ProfileViewModel
) : BaseViewModel() {

    private val currentTabPosition: MutableStateFlow<Int> = MutableStateFlow(0);
    val currentTabPositionValue = currentTabPosition;

    suspend fun updatePagerState(pagerState: PagerState, tabPosition: Int) {
        if (currentTabPosition.value != tabPosition) {
            currentTabPosition.value = tabPosition
        }
        pagerState.animateScrollToPage(tabPosition)
    }
}