package com.get.set.auth.data.repositories

import com.get.set.coremodule.AppLogs
import com.get.set.auth.data.datasource.remote_datasource.auth.AuthDataSource
import com.get.set.auth.data.entity.UserEntity
import com.get.set.auth.domain.models.UserModel
import com.get.set.auth.domain.repositories.AuthRepository

class AuthRepositoryImpl(private val authDataSource: AuthDataSource): AuthRepository() {
    override suspend fun signInWithGoogle(): UserModel {
        val userEntity: UserEntity = authDataSource.signInWithGoogle();
        return userEntity
    }

    override suspend fun logout(): Boolean {
        return authDataSource.logout()
    }
}