package com.get.set.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.get.set.designsystem.util.AppColors
import com.get.set.designsystem.util.getDaysInMonth
import kotlinx.datetime.DatePeriod
import kotlinx.datetime.LocalDate
import kotlinx.datetime.minus
import kotlinx.datetime.plus

@Composable
fun AppCalendar(onChangeDate: (LocalDate) -> Unit, value: LocalDate, lazyListState: LazyListState) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                Icons.AutoMirrored.Default.ArrowBack,
                contentDescription = "ArrowBack",
                modifier = Modifier.clickable {
                    onChangeDate(
                        value.minus(period = DatePeriod(months = 1))
                    )
                })
            Box(modifier = Modifier.width(10.dp))
            Row {
                AppText(
                    value.month.name,
                    size = 16,
                    fontWeight = FontWeight.W600
                )
                AppText(
                    ", ${value.year}",
                    size = 12,
                    fontWeight = FontWeight.W300
                )
            }
            Box(modifier = Modifier.width(10.dp))
            Icon(
                Icons.AutoMirrored.Default.ArrowForward,
                contentDescription = "ArrowFront",
                modifier = Modifier.clickable {
                    onChangeDate(
                        value.plus(period = DatePeriod(months = 1))
                    )
                })
        }
        VerticalSpacer(10)
        LazyRow(
            state = lazyListState
        ) {
            items(value.getDaysInMonth().size) { it ->
                Box(
                    modifier = Modifier.background(
                        shape = RoundedCornerShape(20.dp),
                        color = if (value.getDaysInMonth()[it] == value
                        ) AppColors.primaryColor else Color.Transparent,
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
                            .clickable {
                                onChangeDate(
                                    value.getDaysInMonth()[it]
                                )
                            },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AppText(
                            value.getDaysInMonth()[it].dayOfWeek.name.substring(
                                startIndex = 0,
                                endIndex = 3
                            ),
                            size = 10,
                            fontWeight = FontWeight.W500,
                            color = if (value.getDaysInMonth()[it] == value
                            ) AppColors.white else AppColors.onyxBlack
                        )
                        AppText(
                            value.getDaysInMonth()[it].day.toString(),
                            size = 16,
                            fontWeight = FontWeight.W600,
                            color = if (value.getDaysInMonth()[it] == value
                            ) AppColors.white else AppColors.onyxBlack
                        )

                    }
                }
            }
        }
    }
}