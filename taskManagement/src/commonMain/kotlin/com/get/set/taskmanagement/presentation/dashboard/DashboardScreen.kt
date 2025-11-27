package com.get.set.taskmanagement.presentation.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.get.set.coremodels.models.UserDataModel
import com.get.set.coremodule.BasePage
import com.get.set.coremodule.utils.DateUtils
import com.get.set.designsystem.components.AppText
import com.get.set.designsystem.components.AppTextField
import com.get.set.designsystem.components.VerticalSpacer
import com.get.set.designsystem.util.AppColors
import com.get.set.taskmanagement.utils.greetings
import kotlin.time.ExperimentalTime

class DashboardScreen(private val dashboardViewModel: DashboardViewModel, val dashboardScreenParams: DashboardScreenParams): BasePage<DashboardViewModel>(dashboardViewModel) {

    @OptIn(ExperimentalTime::class)
    @Composable
    override fun Content(paddingValues: PaddingValues, viewModel: DashboardViewModel) {

        val scrollState = rememberScrollState()
        var findYourTask by remember { mutableStateOf("") }
        Box(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.verticalScroll(scrollState).fillMaxWidth().fillMaxHeight()
            ) {
                VerticalSpacer(30)
                AppText((dashboardScreenParams.userDataModel.displayName?:"").greetings(), size = 24, fontWeight = FontWeight.W800)
                AppText(DateUtils.getCurrentDateTime(), size = 12, fontWeight = FontWeight.W400, color = AppColors.onyxBlack)
                VerticalSpacer(12)
                AppTextField(
                    value = findYourTask,
                    onValueChange = {
                        findYourTask = it
                    },
                    label = "Find your task",
                    trailingIcon = {
                        Box(
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search"
                            )
                        }
                    }
                )
            }
        }
    }
}

data class DashboardScreenParams (val userDataModel: UserDataModel) {

}