package com.get.set.taskmanagement.presentation.task

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.get.set.coremodule.AppLogs
import com.get.set.coremodule.BasePage
import com.get.set.coremodule.utils.DateUtils
import com.get.set.designsystem.AppTimerDialog
import com.get.set.designsystem.components.AppPrimaryButton
import com.get.set.designsystem.components.AppText
import com.get.set.designsystem.components.AppTextField
import com.get.set.designsystem.components.VerticalSpacer
import com.get.set.designsystem.util.AppColors

class TaskScreen(private val taskViewModel: TaskViewModel) :
    BasePage<TaskViewModel>(taskViewModel) {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content(paddingValues: PaddingValues, viewModel: TaskViewModel) {

        var title by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }
        var category by remember { mutableStateOf("") }
        var date by remember { mutableStateOf("") }
        var startTimeDialog by remember { mutableStateOf(false) }
        var endTimeDialog by remember { mutableStateOf(false) }
        val taskScreenState = viewModel.taskScreenState.collectAsState()
        val listItems = (1..5).toList()
        val scrollState = rememberScrollState()
        val startTimePickerState = rememberTimePickerState()
        val endTimePickerState = rememberTimePickerState()

        if (startTimeDialog) {
            AppTimerDialog(startTimePickerState, onDissmiss = {
                startTimeDialog = false
            }, onConfirm = {
                startTimeDialog = false
                taskViewModel.updateStartTime(
                    DateUtils.formatTime(
                        hour = it.hour, minute = it.minute, isAfterNoon = it.isAfternoon
                    )
                )
            })
        }

        if (endTimeDialog) {
            AppTimerDialog(endTimePickerState, onDissmiss = {
                endTimeDialog = false
            }, onConfirm = {
                endTimeDialog = false
                taskViewModel.updateEndTime(
                    DateUtils.formatTime(
                        hour = it.hour, minute = it.minute, isAfterNoon = it.isAfternoon
                    )
                )
            })
        }

        Column(
            modifier = Modifier.verticalScroll(scrollState).padding(16.dp)
        ) {
            VerticalSpacer(60)
            AppTextField(
                showLabelOnTop = true,
                value = title,
                onValueChange = {
                    title = it
                    viewModel.updateTitle(it);
                },
                label = "Title",

                ) { it ->
                if (it.length < 3) return@AppTextField "Title should be at least 3 characters long" else return@AppTextField null
            }
            VerticalSpacer(30)
            AppTextField(
                showLabelOnTop = true, value = description, onValueChange = {
                    description = it;
                    viewModel.updateDescription(it);
                }, label = "Description"
            ) { it ->
                if (it.length < 3) return@AppTextField "Description should be at least 3 characters long" else return@AppTextField null
            }
            VerticalSpacer(30)
            AppTextField(
                showLabelOnTop = true,
                value = taskScreenState.value.date ?: "",
                enabled = false,
                onValueChange = {

                },
                label = "Date"
            )
            VerticalSpacer(30)

            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier.weight(0.5F)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier.weight(0.6F).clickable {
                                startTimeDialog = true
                            }) {
                            AppTextField(
                                showLabelOnTop = true,
                                value = taskScreenState.value.startTime ?: "Select",
                                onValueChange = {

                                },
                                enabled = false,
                                label = "Start time"
                            )
                        }

                    }
                }

                Box(modifier = Modifier.weight(0.2F))

                Box(
                    modifier = Modifier.weight(0.5F)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier.weight(0.6F).clickable {
                                endTimeDialog = true;
                            }) {
                            AppTextField(
                                showLabelOnTop = true,
                                value = taskScreenState.value.endTime ?: "Select",
                                onValueChange = {

                                },
                                label = "End time",
                                enabled = false,
                            )
                        }
                    }
                }
            }
            VerticalSpacer(30)
            AppTextField(showLabelOnTop = true, value = category, onValueChange = {
                category = it;

            }, label = "Category", trailingIcon = {
                Box(
                    modifier = Modifier.background(
                        shape = CircleShape,
                        color = if (category.trim()
                                .isNotEmpty()
                        ) AppColors.primaryColor else AppColors.grey002
                    ).clickable {
                        if (category.trim().isNotEmpty()) {
                            viewModel.addCategory(category);
                            category = "";
                        }
                    }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = if (category.trim()
                                .isNotEmpty()
                        ) AppColors.white else AppColors.grey,
                        modifier = Modifier.padding(6.dp)
                    )
                }
            })
            VerticalSpacer(30)
            AnimatedVisibility(visible = taskScreenState.value.categories.isNotEmpty()) {
                Box(
                    modifier = Modifier.fillMaxWidth().background(
                        color = AppColors.lightGrey, shape = RoundedCornerShape(16.dp)
                    ).padding(16.dp)
                ) {
                    FlowRow(
                    ) {
                        taskScreenState.value.categories.forEach {
                            Box(
                                modifier = Modifier.padding(end = 8.dp, bottom = 8.dp)
                            ) {
                                Box(
                                    modifier = Modifier.background(
                                        color = it.color.copy(alpha = 0.2F),
                                        shape = RoundedCornerShape(8.dp)
                                    ).padding(vertical = 8.dp, horizontal = 12.dp)
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        AppText(it.label, color = it.color)
                                        Box(modifier = Modifier.width(10.dp))
                                        Icon(
                                            Icons.Default.Delete,
                                            contentDescription = "Delete Category",
                                            tint = Color.Red,
                                            modifier = Modifier.size(16.dp).clickable {
                                                viewModel.removeCategory(it)
                                            },

                                            )
                                    }
                                }
                            }
                        }
                    }
                }
            }
            VerticalSpacer(80)
        }
    }

    @Composable
    override fun BottomNavBar() {
        val taskScreenState = viewModel.taskScreenState.collectAsState()
        Box(
            modifier = Modifier.padding(16.dp)
        ) {
            AppPrimaryButton(
                buttonStatus = taskScreenState.value.buttonStatus,
                onTap = {

                },
                label = "Create a new task",
            )
        }
    }
}