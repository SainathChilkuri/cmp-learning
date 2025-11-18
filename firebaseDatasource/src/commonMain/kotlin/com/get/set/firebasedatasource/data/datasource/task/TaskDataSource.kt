package com.get.set.firebasedatasource.data.datasource.task

import com.get.set.firebasedatasource.domain.usecases.task.CreateTaskUseCaseParams

abstract class TaskDataSource {
    abstract suspend fun createTask(createTaskUseCaseParams: CreateTaskUseCaseParams): Boolean
}