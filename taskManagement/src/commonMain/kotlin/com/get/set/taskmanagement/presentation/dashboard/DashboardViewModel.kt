package com.get.set.taskmanagement.presentation.dashboard

import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.TabPosition
import androidx.lifecycle.viewModelScope
import com.get.set.coremodule.AppLogs
import com.get.set.coremodule.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DashboardViewModel: BaseViewModel() {

    suspend fun updatePagerState(pagerState: PagerState, tabPosition: Int) {
        AppLogs.info("to ${tabPosition}","Tabs")
                pagerState.animateScrollToPage(tabPosition)
    }
}