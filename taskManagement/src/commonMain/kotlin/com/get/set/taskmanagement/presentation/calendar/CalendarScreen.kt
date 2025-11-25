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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.get.set.coremodels.models.UserDataModel
import com.get.set.coremodule.BasePage
import com.get.set.coremodule.utils.DateUtils
import com.get.set.designsystem.components.AppCalendar
import com.get.set.designsystem.components.AppText
import com.get.set.designsystem.components.VerticalSpacer
import com.get.set.designsystem.util.AppColors
import com.get.set.designsystem.util.DSAsset
import kotlinx.datetime.DatePeriod
import kotlinx.datetime.LocalDate
import kotlinx.datetime.minus
import kotlinx.datetime.plus
import org.jetbrains.compose.resources.painterResource

class CalendarScreen(
    private val calendarViewModel: CalendarViewModel, val userDataModel: UserDataModel
) : BasePage<CalendarViewModel>(calendarViewModel) {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content(paddingValues: PaddingValues, viewModel: CalendarViewModel) {
        val scrollState = rememberScrollState();
        val lazyListState = rememberLazyListState()
        val calendarState = viewModel.selectedDateValue.collectAsState()

        LaunchedEffect(Unit) {
            lazyListState.animateScrollToItem(viewModel.selectedDateValue.value.day - 0)
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
                LazyColumn(

                ) {
                    items(10) {
                        Column {
                            VerticalSpacer(10)
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                AppText(
                                    "08:00  AM",
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
                                            "Continue Project",
                                            size = 14,
                                            fontWeight = FontWeight.W600,
                                            color = if (it == 1) AppColors.white else AppColors.onyxBlack
                                        )
                                        VerticalSpacer(4)
                                        AppText(
                                            "8:00 AM - 9:00 AM",
                                            size = 10,
                                            fontWeight = FontWeight.W400,
                                            color = AppColors.grey003
                                        )

                                    }
                                }

                            }
                            VerticalSpacer(10)
                        }
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