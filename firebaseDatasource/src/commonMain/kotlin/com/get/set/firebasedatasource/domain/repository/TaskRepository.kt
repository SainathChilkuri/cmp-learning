package com.get.set.firebasedatasource.domain.repository

import com.get.set.firebasedatasource.domain.usecases.task.CreateTaskUseCaseParams

abstract class TaskRepository {
    abstract suspend fun createTask(createTaskUseCaseParams: CreateTaskUseCaseParams): Boolean
}