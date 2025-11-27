package com.get.set.auth.data.datasource.remote_datasource.auth

import com.get.set.auth.data.entity.UserEntity
import com.get.set.coremodule.AppCustomException
import com.get.set.firebasedatasource.core.FirebaseAuthWithGoogle
import com.get.set.firebasedatasource.model.GoogleAccountData


class AuthDatasourceImpl(private val firebaseAuthWithGoogle: FirebaseAuthWithGoogle): AuthDataSource() {
    override suspend fun signInWithGoogle(): UserEntity {
        try{
             val data: GoogleAccountData? = firebaseAuthWithGoogle.signIn();
            if(data?.email != null) {
                return  UserEntity(
                    usernameValue = data.username,
                    displayNameValue = data.displayName ?: "",
                    emailValue = data.email ?: ""
                )
            }
            throw AppCustomException("Unable to sign in with google", tag = "Auth")
        }catch (e: Exception) {
            throw AppCustomException(e.message?:e.toString(), tag = "Auth")
        }
    }

    override suspend fun logout(): Boolean {
       firebaseAuthWithGoogle.signOut()
        return true;
    }
}