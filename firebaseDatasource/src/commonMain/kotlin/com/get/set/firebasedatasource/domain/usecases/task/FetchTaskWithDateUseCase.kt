package com.get.set.firebasedatasource.domain.usecases.task

import com.get.set.coremodels.models.TaskModel
import com.get.set.coremodule.BaseUseCase
import com.get.set.firebasedatasource.domain.repository.TaskRepository

class FetchTaskWithDateUseCase(private val taskRepository: TaskRepository): BaseUseCase<List<TaskModel>,FetchTaskWithDateUseCaseParams>() {
    override suspend fun execute(params: FetchTaskWithDateUseCaseParams): List<TaskModel> {
       return taskRepository.fetchTask(params.date, params.userId)
    }
}

class FetchTaskWithDateUseCaseParams(val date: String, val userId: String)