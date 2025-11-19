package com.get.set.firebasedatasource.data.datasource.user

import com.get.set.coremodels.models.UserDataModel
import com.get.set.coremodule.AppCustomException
import com.get.set.coremodule.AppLogs
import com.get.set.firebasedatasource.core.CollectionConstants
import com.get.set.firebasedatasource.domain.usecases.user.CreateUserUseCaseParams
import dev.gitlive.firebase.firestore.DocumentReference
import dev.gitlive.firebase.firestore.FieldPath
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.where

class UserDataSourceImpl(private val firestore: FirebaseFirestore): UserDataSource() {
    override suspend fun createUser(createUserUseCaseParams: CreateUserUseCaseParams): UserDataModel {

        try {
            val userData = firestore.collection(CollectionConstants.USER).where {
                "email" equalTo(createUserUseCaseParams.email)
            }.get()

            if(userData.documents.isEmpty()) {
                val result: DocumentReference = firestore.collection(CollectionConstants.USER).add(createUserUseCaseParams)
                ///TODO: Send User Details Back to Viewmodel From Firebase
                return result.get().data<UserDataModel>();
            }else{
                return userData.documents.first().data<UserDataModel>();
            }
        }catch (e: Exception) {
            throw AppCustomException(e.message?:"Failed to create user","Firestore Exception")
        }
    }
}