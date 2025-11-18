package com.get.set.taskmanagement.presentation.task

import com.get.set.designsystem.components.AppPrimaryButtonStatus

data class TaskScreenState(
    val categories: List<Categories> = emptyList<Categories>(),
    val title: String? = null,
    val description: String? = null,
    val date: String? = null,
    val startTime: String? = null,
    val endTime: String? = null,
    val buttonStatus: AppPrimaryButtonStatus = AppPrimaryButtonStatus.DISABLED
) {
}