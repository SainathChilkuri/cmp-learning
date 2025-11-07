package com.get.set.auth.data.repositories

import UserTableEntity
import com.get.set.coremodule.AppLogs
import com.get.set.auth.data.datasource.remote_datasource.auth.AuthDataSource
import com.get.set.auth.data.entity.UserEntity
import com.get.set.database.data.datasource.local_datasource.LocalDataSource
import com.get.set.auth.domain.models.UserModel
import com.get.set.auth.domain.repositories.AuthRepository

class AuthRepositoryImpl(private val authDataSource: AuthDataSource): AuthRepository() {
    override suspend fun signInWithGoogle(): UserModel {
        val userEntity: UserEntity = authDataSource.signInWithGoogle();
        AppLogs.info("User Details---->${userEntity.displayName}","Auth")
        return userEntity
    }
}