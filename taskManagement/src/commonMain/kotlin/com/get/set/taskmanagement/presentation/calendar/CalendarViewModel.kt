package com.get.set.taskmanagement.presentation.calendar

import com.get.set.coremodule.AppLogs
import com.get.set.coremodule.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

class CalendarViewModel : BaseViewModel() {
    @OptIn(ExperimentalTime::class)
    private var selectedDate = MutableStateFlow<LocalDate>(
        Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    )

    var selectedDateValue = selectedDate;

    fun onChangeDate(newDate: LocalDate) {
        selectedDate.value = newDate
        AppLogs.info("New Date ${selectedDate.value.month.ordinal} ${selectedDate.value.year} ${selectedDate.value.day}","DateTime")

    }

}