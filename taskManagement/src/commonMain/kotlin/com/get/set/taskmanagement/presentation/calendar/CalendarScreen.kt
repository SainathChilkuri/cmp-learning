package com.get.set.taskmanagement.presentation.calendar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowDropDownCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.CalendarLocale
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.get.set.coremodels.models.UserDataModel
import com.get.set.coremodule.BasePage
import com.get.set.coremodule.DataState
import com.get.set.coremodule.utils.DateUtils
import com.get.set.designsystem.components.AppCalendar
import com.get.set.designsystem.components.AppText
import com.get.set.designsystem.components.VerticalSpacer
import com.get.set.designsystem.util.AppColors
import com.get.set.designsystem.util.DSAsset
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.datetime.DatePeriod
import kotlinx.datetime.LocalDate
import kotlinx.datetime.minus
import kotlinx.datetime.plus
import org.jetbrains.compose.resources.painterResource

class CalendarScreen(
    private val calendarViewModel: CalendarViewModel, private val userDataModel: UserDataModel
) : BasePage<CalendarViewModel>(calendarViewModel) {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content(paddingValues: PaddingValues, viewModel: CalendarViewModel) {
        val scrollState = rememberScrollState();
        val lazyListState = rememberLazyListState()
        val calendarState = viewModel.selectedDateValue.collectAsState()
        val taskStates = viewModel.calendarScreenStateValue.collectAsStateWithLifecycle()
        val scope = rememberCoroutineScope()

        LaunchedEffect(Unit) {
            lazyListState.animateScrollToItem(viewModel.selectedDateValue.value.day - 0)
            viewModel.fetchTasks(userId = userDataModel.userId)
        }


        Box(
            modifier = Modifier.padding(paddingValues).padding(horizontal = 16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppCalendar(
                    onChangeDate = {
                        viewModel.onChangeDate(it)
                        scope.launch {
                            viewModel.fetchTasks(userId = userDataModel.userId)
                        }
                    }, value = calendarState.value, lazyListState = lazyListState
                )

                VerticalSpacer(15)
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(DSAsset.divider),
                        contentDescription = "Divider",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                VerticalSpacer(15)
                 when(taskStates.value.dataState) {
                     DataState.LOADING -> {
                         CircularProgressIndicator(
                             modifier = Modifier.height(50.dp).width(50.dp)
                         )
                     }
                     DataState.SUCCESS -> {
                         LazyColumn(

                         ) {
                             items(taskStates.value.taskModels.size) {
                                 Column {
                                     VerticalSpacer(10)
                                     Row(
                                         verticalAlignment = Alignment.CenterVertically,
                                         modifier = Modifier.fillMaxWidth()
                                     ) {
                                         AppText(
                                             taskStates.value.taskModels[it].taskStartTime.split(" ").first(),
                                             size = 14,
                                             fontWeight = FontWeight.W500,
                                             color = AppColors.onyxBlack,
                                             modifier = Modifier.weight(2F)
                                         )
                                         Box(modifier = Modifier.width(10.dp))
                                         Box(
                                             modifier = Modifier.shadow(
                                                 elevation = 10.dp,
                                                 shape = RoundedCornerShape(8.dp),
                                                 clip = false
                                             ).background(
                                                 color = if (it == 1) AppColors.primaryColor else AppColors.white,
                                                 shape = RoundedCornerShape(8.dp),
                                             ).weight(7F)
                                         ) {
                                             Column(
                                                 horizontalAlignment = Alignment.Start,
                                                 modifier = Modifier.padding(
                                                     vertical = 10.dp, horizontal = 16.dp
                                                 )
                                             ) {
                                                 AppText(
                                                     taskStates.value.taskModels[it].taskTitle,
                                                     size = 14,
                                                     fontWeight = FontWeight.W600,
                                                     color = if (it == 1) AppColors.white else AppColors.onyxBlack
                                                 )
                                                 AppText(
                                                     taskStates.value.taskModels[it].taskDescription,
                                                     size = 12,
                                                     fontWeight = FontWeight.W400,
                                                     color = if (it == 1) AppColors.white else AppColors.onyxBlack
                                                 )
                                                 VerticalSpacer(4)
                                                 AppText(
                                                     "${taskStates.value.taskModels[it].taskStartTime} - ${taskStates.value.taskModels[it].taskEndTime}",
                                                     size = 10,
                                                     fontWeight = FontWeight.W400,
                                                     color = AppColors.onyxBlack
                                                 )

                                             }
                                         }

                                     }
                                     VerticalSpacer(10)
                                 }
                             }
                         }
                     }
                     DataState.FAILED -> {
                         AppText("Something went wrong, please try again")
                     }
                     else-> {
                         AppText("")
                     }
                 }
                VerticalSpacer(70)
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
            })

    }
}