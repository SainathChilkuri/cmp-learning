package com.get.set.coremodels.models

import kotlinx.serialization.Serializable

@Serializable
data class TaskModel(
    val taskId: String,
    val taskTitle: String,
    val taskDescription: String,
    val taskStartTime: String,
    val taskEndTime: String,
    val categories: List<String>,
    val taskDate: String,
    val taskTimeStamp: String,
    val taskStatus: String,
    val userId: String
) {
}