package com.get.set.designsystem.util

import kotlinx.datetime.LocalDate

fun LocalDate.getDaysInMonth(): List<LocalDate> {
    val daysInMonth = getDaysInMonth(month.ordinal + 1, year)
    return List<LocalDate>(daysInMonth) {
        LocalDate(year, month, it + 1)
    }
}


private fun getDaysInMonth(month: Int, year: Int): Int {
    return if(month == 2) {
        if(year%4 == 0) {
            29;
        }else{
            28;
        }
    }else{
        if(month <= 7) {
            if(month%2==0) 30 else 31
        }else if(month > 7 ) {
            if(month%2==0) 31 else 30;
        }else{
            30;
        }
    }
}