package com.get.set.taskmanagement.presentation.task

import androidx.compose.ui.graphics.Color
import com.get.set.coremodule.AppCustomException
import com.get.set.coremodule.AppLogs
import com.get.set.coremodule.BaseViewModel
import com.get.set.coremodule.DataState
import com.get.set.coremodule.executeUseCase
import com.get.set.coremodule.utils.DateUtils
import com.get.set.designsystem.components.AppPrimaryButtonStatus
import com.get.set.designsystem.util.AppColors
import com.get.set.firebasedatasource.domain.usecases.task.CreateTaskUseCase
import com.get.set.firebasedatasource.domain.usecases.task.CreateTaskUseCaseParams
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class TaskViewModel(private val createTaskUseCase: CreateTaskUseCase) : BaseViewModel() {

    private val _taskScreenState: MutableStateFlow<TaskScreenState> =
        MutableStateFlow<TaskScreenState>(
            TaskScreenState(
                date = DateUtils.getCurrentDateTimeWithWeek()
            )
        )

    var taskScreenState: StateFlow<TaskScreenState> = _taskScreenState;


    private val randomColors = listOf(
        AppColors.randomColor001,
        AppColors.randomColor002,
        AppColors.randomColor003,
        AppColors.randomColor004,
        AppColors.randomColor005,
        AppColors.randomColor006,
        AppColors.randomColor007,
        AppColors.randomColor008,
        AppColors.randomColor009,
    )


    private fun getRandomColor(): Color {
        return randomColors[(0..8).random()]
    }

    fun addCategory(value: String) {
        val category = Categories(label = value, color = getRandomColor())
        if (!_taskScreenState.value.categories.contains(category)) {
            val categories = _taskScreenState.value.categories.toMutableList();
            categories += category
            AppLogs.info("Status ${getButtonStatus()}", "button")
            _taskScreenState.value = _taskScreenState.value.copy(categories = categories)
            updateButtonStatus()
        }
    }

    fun updateEndTime(value: String) {
        _taskScreenState.value = _taskScreenState.value.copy(endTime = value)
        updateButtonStatus()
    }

    fun updateTitle(value: String) {
        _taskScreenState.value = _taskScreenState.value.copy(title = value)
        updateButtonStatus()

    }

    fun updateDescription(value: String) {
        _taskScreenState.value = _taskScreenState.value.copy(description = value)
        updateButtonStatus()
    }

    fun updateStartTime(value: String) {
        _taskScreenState.value = _taskScreenState.value.copy(startTime = value)
        updateButtonStatus()
    }

    fun removeCategory(category: Categories) {
        if (_taskScreenState.value.categories.contains(category)) {
            val categories = _taskScreenState.value.categories.toMutableList();
            categories -= category
            _taskScreenState.value = _taskScreenState.value.copy(categories = categories)
            updateButtonStatus()
        }
    }

    private fun getButtonStatus(): AppPrimaryButtonStatus {
        return if (((_taskScreenState.value.title
                ?: "").length > 3) && (_taskScreenState.value.description
                ?: "").length > 3 && (_taskScreenState.value.startTime
                ?: "").isNotEmpty() && (_taskScreenState.value.endTime
                ?: "").isNotEmpty() && _taskScreenState.value.categories.isNotEmpty()
        ) {
            AppPrimaryButtonStatus.ACTIVE
        } else {
            AppPrimaryButtonStatus.DISABLED
        }
    }

    private fun updateButtonStatus() {
        _taskScreenState.value = _taskScreenState.value.copy(buttonStatus = getButtonStatus())
    }

    @OptIn(ExperimentalUuidApi::class)
    suspend fun createNewTask(userId: String) {
        _taskScreenState.value = _taskScreenState.value.copy(
            dataState = DataState.LOADING,
            buttonStatus = AppPrimaryButtonStatus.LOADING
        )
        executeUseCase<CreateTaskUseCaseParams, Boolean, AppCustomException, CreateTaskUseCase>(
            useCase = createTaskUseCase,
            params = CreateTaskUseCaseParams(
                taskTitle = _taskScreenState.value.title ?: "",
                taskDescription = _taskScreenState.value.description ?: "",
                userId = userId,
                taskStartTime = _taskScreenState.value.startTime ?: "",
                taskEndTime = _taskScreenState.value.endTime ?: "",
                categories = _taskScreenState.value.categories.map { it.label }.toList(),
                taskDate = DateUtils.getCurrentDateInISO().split("T").first(),
                taskId = Uuid.random().toHexDashString(),
                taskTimeStamp = DateUtils.getCurrentDateInISO(),
                taskStatus = "IN-PROGRESS"

            ),
            onSuccess = {
                clearAllFields()
            },
            onError = {
                _taskScreenState.value = _taskScreenState.value.copy(
                    dataState = DataState.FAILED,
                    buttonStatus = AppPrimaryButtonStatus.ACTIVE
                )
            }
        )
    }

    private fun clearAllFields() {
        _taskScreenState.value = _taskScreenState.value.copy(
            title = null,
            description = null,
            date = null,
            endTime = null,
            startTime = null,
            categories = emptyList(),
            dataState = DataState.SUCCESS,
            buttonStatus = AppPrimaryButtonStatus.DISABLED
        )
    }

    fun resetDataState() {
        _taskScreenState.value = _taskScreenState.value.copy(dataState = DataState.INITIAL)
    }
}

data class Categories(val label: String, val color: Color)