package com.get.set.firebasedatasource.data.datasource.task

import com.get.set.coremodule.AppCustomException
import com.get.set.firebasedatasource.core.CollectionConstants
import com.get.set.firebasedatasource.domain.usecases.task.CreateTaskUseCaseParams
import dev.gitlive.firebase.firestore.DocumentReference
import dev.gitlive.firebase.firestore.FirebaseFirestore

class TaskDataSourceImpl(private val firestore: FirebaseFirestore): TaskDataSource() {
    override suspend fun createTask(createTaskUseCaseParams: CreateTaskUseCaseParams): Boolean {
        try {
                val result: DocumentReference = firestore.collection(CollectionConstants.TASK).add(createTaskUseCaseParams)
                return true;
        }catch (e: Exception) {
            throw AppCustomException(e.message?:"Failed to create task","Firestore Exception")
        }
    }
}