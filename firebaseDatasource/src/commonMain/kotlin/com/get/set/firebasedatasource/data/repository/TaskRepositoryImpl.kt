package com.get.set.firebasedatasource.data.repository

import com.get.set.firebasedatasource.data.datasource.task.TaskDataSource
import com.get.set.firebasedatasource.domain.repository.TaskRepository
import com.get.set.firebasedatasource.domain.usecases.task.CreateTaskUseCaseParams

class TaskRepositoryImpl(private val taskDataSource: TaskDataSource): TaskRepository() {
    override suspend fun createTask(createTaskUseCaseParams: CreateTaskUseCaseParams): Boolean {
       return  taskDataSource.createTask(createTaskUseCaseParams);
    }
}