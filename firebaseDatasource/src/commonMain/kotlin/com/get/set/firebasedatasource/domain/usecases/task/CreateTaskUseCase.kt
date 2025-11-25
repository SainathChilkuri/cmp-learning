package com.get.set.firebasedatasource.domain.usecases.task

import com.get.set.coremodule.BaseUseCase
import com.get.set.firebasedatasource.domain.repository.TaskRepository
import kotlinx.serialization.Serializable

class CreateTaskUseCase(private val taskRepository: TaskRepository): BaseUseCase<Boolean, CreateTaskUseCaseParams>() {
    override suspend fun execute(params: CreateTaskUseCaseParams): Boolean {
        return taskRepository.createTask(params)
    }
}

@Serializable
data class CreateTaskUseCaseParams (
    val userId: String,
    val taskTitle: String,
    val taskDescription: String,
    val taskTimeStamp: String,
    val taskStartTime: String,
    val taskEndTime: String,
    val categories: List<String>,
    val taskId: String,
    val taskDate: String,
    val taskStatus: String
) {}