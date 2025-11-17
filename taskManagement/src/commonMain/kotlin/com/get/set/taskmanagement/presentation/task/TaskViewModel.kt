package com.get.set.taskmanagement.presentation.task

import com.get.set.coremodule.AppLogs
import com.get.set.coremodule.BaseViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

class TaskViewModel: BaseViewModel() {

    private val _categories: MutableStateFlow<List<String>> = MutableStateFlow<List<String>>(listOf<String>())

    var categories = _categories;

    fun addCategory(value: String) {
        AppLogs.info("Categories: ${value}","Category")
        if(!categories.value.contains(value)) {
            categories.value += value
            AppLogs.info("Categories: ${categories.value}","Category")
        }
        AppLogs.info("Categories: ${categories.value}","Category")
    }

    fun removeCategory(value: String) {
        if(_categories.value.contains(value)) {
            categories.value -= value
        }
    }
}