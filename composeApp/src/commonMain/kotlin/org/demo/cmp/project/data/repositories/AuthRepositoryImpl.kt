package org.demo.cmp.project.data.repositories

import UserEntity
import org.demo.cmp.project.core.AppLogs
import org.demo.cmp.project.data.datasource.local_datasource.LocalDataSource
import org.demo.cmp.project.data.datasource.remote_datasource.auth.AuthDataSource
import org.demo.cmp.project.domain.models.GoogleAccountData
import org.demo.cmp.project.domain.models.UserModel
import org.demo.cmp.project.domain.repositories.AuthRepository

class AuthRepositoryImpl(private val localDataSource: LocalDataSource, private val authDataSource: AuthDataSource): AuthRepository() {
    override suspend fun signInWithGoogle(): UserModel {
        val userEntity: UserEntity = authDataSource.signInWithGoogle();
        AppLogs.info("User Details---->${userEntity.displayName}","Auth")
        localDataSource.saveLoggedInUser(userEntity);
        return  UserModel(
            email = userEntity.email,
            displayName = userEntity.displayName,
            username = userEntity.username ?: ""
        )
    }
}