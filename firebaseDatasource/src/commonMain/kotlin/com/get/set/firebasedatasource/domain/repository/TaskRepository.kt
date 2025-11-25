package com.get.set.firebasedatasource.domain.repository

import com.get.set.coremodels.models.TaskModel
import com.get.set.firebasedatasource.domain.usecases.task.CreateTaskUseCaseParams
import com.get.set.firebasedatasource.domain.usecases.task.FetchTaskWithDateUseCase
import com.get.set.firebasedatasource.domain.usecases.task.FetchTaskWithDateUseCaseParams

abstract class TaskRepository {
    abstract suspend fun createTask(createTaskUseCaseParams: CreateTaskUseCaseParams): Boolean

    abstract suspend fun fetchTask(date: String, userId: String): List<TaskModel>
}