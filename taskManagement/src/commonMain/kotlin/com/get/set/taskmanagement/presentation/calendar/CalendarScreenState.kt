package com.get.set.taskmanagement.presentation.calendar

import com.get.set.coremodels.models.TaskModel
import com.get.set.coremodule.BaseState
import com.get.set.coremodule.DataState

data class CalendarScreenState(val taskModels: List<TaskModel>, val dataState: DataState): BaseState(dataState) {
}