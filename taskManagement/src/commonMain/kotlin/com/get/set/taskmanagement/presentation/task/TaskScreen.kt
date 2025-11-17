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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.get.set.coremodule.BasePage
import com.get.set.designsystem.components.AppPrimaryButton
import com.get.set.designsystem.components.AppText
import com.get.set.designsystem.components.AppTextField
import com.get.set.designsystem.components.VerticalSpacer
import com.get.set.designsystem.util.AppColors

class TaskScreen(private  val taskViewModel: TaskViewModel): BasePage<TaskViewModel>(taskViewModel) {

    @Composable
    override fun Content(paddingValues: PaddingValues, viewModel: TaskViewModel) {

        var title by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }
        var category by remember { mutableStateOf("") }
        var date by remember { mutableStateOf("") }
        var startTime by remember { mutableStateOf("") }
        var endTime by remember { mutableStateOf("") }
        val categories = viewModel.categories.collectAsState()
        val listItems = (1..5).toList()
        val scrollState = rememberScrollState()


        Column (
            modifier = Modifier.verticalScroll(scrollState).padding(16.dp)
        ) {
            VerticalSpacer(60)
            AppTextField(
                showLabelOnTop = true,
                value = title,
                onValueChange = {
                    title = it

                },
                label = "Title"
            )
            VerticalSpacer(30)
            AppTextField(
                showLabelOnTop = true,
                value = description,
                onValueChange = {
                    description = it;

                },
                label = "Description"
            )
            VerticalSpacer(30)
            AppTextField(
                showLabelOnTop = true,
                value = "",
                enabled = false,
                onValueChange = {

                },
                label = "Date"
            )
            VerticalSpacer(30)

            Row (
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box (
                    modifier = Modifier.weight(0.5F)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box (
                            modifier = Modifier.weight(0.6F)
                        ){
                            AppTextField(
                                showLabelOnTop = true,
                                value = "",
                                onValueChange = {

                                },
                                enabled = false,
                                label = "Start time"
                            )
                        }
                        Box(modifier = Modifier.width(10.dp))
                        Box(
                            modifier = Modifier.padding(top = 5.dp)
                        ) {
                            AppText("PM")
                        }

                    }
                }

                Box(modifier = Modifier.weight(0.2F))

                Box (
                    modifier = Modifier.weight(0.5F)
                ){
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Box (
                            modifier = Modifier.weight(0.6F)
                        ){
                            AppTextField(
                                showLabelOnTop = true,
                                value = "",
                                onValueChange = {

                                },
                                label = "End time",
                                enabled = false,
                            )
                        }
                        Box(modifier = Modifier.width(10.dp))
                        Box(
                            modifier = Modifier.padding(top = 5.dp)
                        ) {
                            AppText("PM")
                        }
                    }
                }
            }
            VerticalSpacer(30)
            AppTextField(
                showLabelOnTop = true,
                value = category,
                onValueChange = {
                    category = it;

                },
                label = "Category",
                trailingIcon = {
                    Box(
                        modifier = Modifier.background(shape = CircleShape, color = if(category.trim().isNotEmpty()) AppColors.primaryColor else AppColors.grey002).clickable {
                            if(category.trim().isNotEmpty()){
                                viewModel.addCategory(category);
                                category = "";
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add",
                            tint = if(category.trim().isNotEmpty()) AppColors.white else AppColors.grey,
                            modifier = Modifier.padding(6.dp)
                        )
                    }
                }
            )
            VerticalSpacer(30)
            AnimatedVisibility(visible = categories.value.isNotEmpty()) {
                Box(
                    modifier = Modifier.fillMaxWidth().background(
                        color = AppColors.lightGrey,
                        shape = RoundedCornerShape(16.dp)
                    ).padding(16.dp)
                ) {
                    FlowRow(
                    ) {
                        categories.value.forEach {
                            Box(
                                modifier = Modifier.padding(end = 8.dp, bottom = 8.dp)
                            ) {
                                Box(
                                    modifier = Modifier.background(
                                        color = AppColors.grey,
                                        shape = RoundedCornerShape(8.dp)
                                    ).padding(vertical = 8.dp, horizontal = 12.dp)
                                ) {
                                    AppText(it)
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
        Box (
            modifier = Modifier.padding(16.dp)
        ) {
            AppPrimaryButton(
                onTap = {

                },
                label = "Create a new task",
            )
        }
    }
}