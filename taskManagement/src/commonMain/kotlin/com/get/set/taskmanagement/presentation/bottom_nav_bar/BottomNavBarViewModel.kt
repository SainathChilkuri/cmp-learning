package com.get.set.taskmanagement.presentation.bottom_nav_bar

import androidx.compose.material3.TabPosition
import androidx.compose.runtime.mutableStateOf
import com.get.set.coremodule.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class BottomNavBarViewModel: BaseViewModel() {
    private val currentTabPosition: MutableStateFlow<Int> =  MutableStateFlow(0);
    val currentTabPositionValue = currentTabPosition;

    fun onTabChange(tabPosition: Int) {
        if(currentTabPosition.value != tabPosition) {
            currentTabPosition.value = tabPosition
        }
    }
}