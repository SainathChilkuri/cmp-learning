package com.get.set.firebasedatasource.data.datasource.user

import com.get.set.coremodule.AppCustomException
import com.get.set.coremodule.AppLogs
import com.get.set.firebasedatasource.domain.usecases.user.CreateUserUseCaseParams
import dev.gitlive.firebase.firestore.DocumentReference
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.where

class UserDataSourceImpl(private val firestore: FirebaseFirestore): UserDataSource() {
    override suspend fun createUser(createUserUseCaseParams: CreateUserUseCaseParams): Boolean {

        try {
            val userData = firestore.collection("user").where {
                "email" equalTo(createUserUseCaseParams.email)
            }.get()

            if(userData.documents.isEmpty()) {
                val result: DocumentReference = firestore.collection("user").add(createUserUseCaseParams)
                return true;
            }else{
                return false;
            }
        }catch (e: Exception) {
            throw AppCustomException(e.message?:"Failed to create user","Firestore Exception")
        }
    }
}