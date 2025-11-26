package com.get.set.firebasedatasource.data.repository

import com.get.set.coremodels.models.TaskModel
import com.get.set.firebasedatasource.data.datasource.task.TaskDataSource
import com.get.set.firebasedatasource.domain.repository.TaskRepository
import com.get.set.firebasedatasource.domain.usecases.task.CreateTaskUseCaseParams
import com.get.set.firebasedatasource.domain.usecases.task.FetchTaskWithDateUseCaseParams

class TaskRepositoryImpl(private val taskDataSource: TaskDataSource) : TaskRepository() {
    override suspend fun createTask(createTaskUseCaseParams: CreateTaskUseCaseParams): Boolean {
        return taskDataSource.createTask(createTaskUseCaseParams);
    }

    override suspend fun fetchTask(date: String, userId: String): List<TaskModel> {
        return taskDataSource.fetchTask(date,userId)
    }
}