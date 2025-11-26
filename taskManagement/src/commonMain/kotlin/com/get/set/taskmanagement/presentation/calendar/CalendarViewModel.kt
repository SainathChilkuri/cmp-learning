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
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format.DateTimeFormat
import kotlinx.datetime.format.char
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class CalendarViewModel(private val taskWithDateUseCase: FetchTaskWithDateUseCase) :
    BaseViewModel() {

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
        calendarScreenState.value =
            calendarScreenState.value.copy(dataState = DataState.LOADING, taskModels = emptyList())
        executeUseCase<FetchTaskWithDateUseCaseParams, List<TaskModel>, AppCustomException, FetchTaskWithDateUseCase>(
            useCase = taskWithDateUseCase,
            onSuccess = {

                calendarScreenState.value = calendarScreenState.value.copy(
                    dataState = DataState.SUCCESS,
                    taskModels = sortTaskWithTimeline(it)
                )
            },
            onError = {
                calendarScreenState.value =
                    calendarScreenState.value.copy(dataState = DataState.FAILED)

            },
            params = FetchTaskWithDateUseCaseParams(
                date = "${selectedDate.value.year}-${selectedDate.value.month.ordinal + 1}-${selectedDate.value.day}",
                userId = userId
            )
        )
    }

    private fun sortTaskWithTimeline(taskModelList: List<TaskModel>): List<TaskModel> {
        return taskModelList.sortedBy {
            it.taskStartTime
        }
    }

    @OptIn(ExperimentalTime::class)
    fun isCurrentTimeSlot(startTime: String, endTime: String, taskDate: String): Boolean {
        val currentDatetime =
            Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

        val time = "${currentDatetime.hour}${currentDatetime.minute}".toInt()
        val date = currentDatetime.toString().split("T").first()
        val startTimein24Hours = get24HourTime(startTime)
        val endTimein24Hours = get24HourTime(endTime)
        AppLogs.info("Dates--->${date} $taskDate","DATE")
        AppLogs.info("Dates--->${time} $startTimein24Hours $endTimein24Hours","DATE")
        return time in startTimein24Hours..endTimein24Hours && date == taskDate
    }

    private fun get24HourTime(time: String): Int {
        AppLogs.info("Dates---> 1 ${time}","DATE")
        var newHour = 0
        val hour = time.split(" ").first().split(":").first().toInt()
        var minute = time.split(" ").first().split(":")[1]
        val meridiem = time.split(" ").last()
        newHour = hour
        AppLogs.info("Dates---> 2 ${hour} $minute $meridiem","DATE")

        if(minute.toInt() < 10 && minute.length < 2) {
            minute = "0$minute"
        }

        if (meridiem == "AM" && hour == 12) {
            newHour = 0
        }
        if (meridiem == "PM" && hour < 12) {
            newHour = hour + 12;
        }
        AppLogs.info("Dates---> 3 ${newHour} $minute $meridiem","DATE")

        return "${newHour}${minute}".toInt()

    }
}


