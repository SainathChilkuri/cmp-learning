package com.get.set.taskmanagement.presentation.calendar

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.get.set.coremodels.models.TaskModel
import com.get.set.coremodels.models.UserDataModel
import com.get.set.coremodule.AppCustomException
import com.get.set.coremodule.AppLogs
import com.get.set.coremodule.BaseViewModel
import com.get.set.coremodule.DataState
import com.get.set.coremodule.executeUseCase
import com.get.set.firebasedatasource.domain.usecases.task.FetchTaskWithDateUseCase
import com.get.set.firebasedatasource.domain.usecases.task.FetchTaskWithDateUseCaseParams
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class CalendarViewModel(private  val taskWithDateUseCase: FetchTaskWithDateUseCase) : BaseViewModel() {

    private var calendarScreenState = MutableStateFlow<CalendarScreenState>(
        CalendarScreenState(
            emptyList(),
            dataState = DataState.INITIAL
        )
    )

    var calendarScreenStateValue = calendarScreenState;

    @OptIn(ExperimentalTime::class)
    private var selectedDate = MutableStateFlow<LocalDate>(
        Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    )

    var selectedDateValue = selectedDate;

    fun onChangeDate(newDate: LocalDate) {
        selectedDate.value = newDate
    }


     suspend fun fetchTasks(userId: String) {
         calendarScreenState.value = calendarScreenState.value.copy(dataState = DataState.LOADING, taskModels = emptyList())
        executeUseCase<FetchTaskWithDateUseCaseParams,List<TaskModel>, AppCustomException, FetchTaskWithDateUseCase>(
            useCase = taskWithDateUseCase,
            onSuccess = {
                calendarScreenState.value = calendarScreenState.value.copy(dataState = DataState.SUCCESS, taskModels = it)
            },
            onError =  {
                calendarScreenState.value = calendarScreenState.value.copy(dataState = DataState.FAILED)

            }, params = FetchTaskWithDateUseCaseParams(date = "${selectedDate.value.year}-${selectedDate.value.month.ordinal + 1}-${selectedDate.value.day}", userId= userId)
        )
    }

}