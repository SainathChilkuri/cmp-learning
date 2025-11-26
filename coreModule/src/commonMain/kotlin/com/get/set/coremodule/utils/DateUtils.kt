package com.get.set.coremodule.utils

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateRange
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.DateTimeFormat
import kotlinx.datetime.format.DateTimeFormatBuilder
import kotlinx.datetime.format.DayOfWeekNames
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.format.char
import kotlinx.datetime.number
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class, FormatStringsInDatetimeFormats::class)
object DateUtils {
    fun getCurrentDateTime(): String {
        val current = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).format(LocalDateTime.Format {
            monthName(MonthNames("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec")); char(' ')
            day(); char(','); char(' '); year()
        })
        return  current
    }

    fun getCurrentDateTimeWithWeek(): String {
        val current = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).format(LocalDateTime.Format {
            dayOfWeek(DayOfWeekNames("Monday","Tuesday", "Wednesday","Thursday","Friday","Saturday","Sunday",),); char(','); char(' ');
            monthName(MonthNames("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec")); char(' ')
            day(); char(','); char(' '); year()
        })
        return  current
    }

    fun getCurrentDateInISO(): String {
      return Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).toString()
    }

    fun formatTime(hour: Int, minute: Int, isAfterNoon: Boolean): String {
        val meridiem = if(isAfterNoon) "PM" else "AM"
        if(hour > 12) {
            return "${hour - 12}:${if(minute < 10) "0$minute" else minute} $meridiem"
        }
        return "$hour:${if(minute < 10) "0$minute" else minute} $meridiem"
    }
}
