package com.get.set.coremodule.utils

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.DateTimeFormat
import kotlinx.datetime.format.DateTimeFormatBuilder
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.format.char
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
        return  current.toString()
    }
}