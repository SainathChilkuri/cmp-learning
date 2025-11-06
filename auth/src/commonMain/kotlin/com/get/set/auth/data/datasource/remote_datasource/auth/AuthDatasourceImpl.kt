package com.get.set.auth.data.datasource.remote_datasource.auth

import com.get.set.auth.data.entity.UserEntity
import com.get.set.coremodule.AppCustomException
import com.get.set.firebasedatasource.model.GoogleAccountData
import com.get.set.firebasedatasource.model.GoogleAccountData

class AuthDatasourceImpl(val firebaseAuthWithGoogle: FirebaseAuthWithGoogle): AuthDataSource() {
    override suspend fun signInWithGoogle(): UserEntity {
        try{
             val data: GoogleAccountData? = GoogleSignInUtil.signIn();
            if(data?.email != null) {
                return  UserEntity(
                    username = data.username,
                    displayName = data.displayName ?: "",
                    email = data.email ?: ""
                )
            }
            throw AppCustomException("Unable to sign in with google", tag = "Auth")
        }catch (e: Exception) {
            throw AppCustomException(e.message?:e.toString(), tag = "Auth")
        }
    }
}