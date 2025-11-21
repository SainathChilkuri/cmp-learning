package com.get.set.taskmanagement.presentation.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CalendarLocale
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.get.set.coremodels.models.UserDataModel
import com.get.set.coremodule.BasePage
import com.get.set.designsystem.components.AppText
import com.get.set.designsystem.components.VerticalSpacer

class CalendarScreen(
    private val calendarViewModel: CalendarViewModel,
    val userDataModel: UserDataModel
) : BasePage<CalendarViewModel>(calendarViewModel) {

    @Composable
    override fun Content(paddingValues: PaddingValues, viewModel: CalendarViewModel) {
        val scrollState = rememberScrollState();
        Box(
            modifier = Modifier.padding(paddingValues)
        ) {
            Column(
                modifier = Modifier.verticalScroll(scrollState)
            ) {
                AppText("Calendar")

            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun TopAppBarUnit() {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors().copy(containerColor = Color.Transparent),
            modifier = Modifier.padding(vertical = 8.dp),
            title = {
                AppText("Schedule", size = 18, fontWeight = FontWeight.W700)
            }
        )

    }
}