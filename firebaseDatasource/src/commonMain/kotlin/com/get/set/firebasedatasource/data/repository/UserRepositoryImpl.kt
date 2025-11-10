package com.get.set.firebasedatasource.data.repository

import com.get.set.firebasedatasource.data.datasource.user.UserDataSource
import com.get.set.firebasedatasource.domain.repository.UserRepository
import com.get.set.firebasedatasource.domain.usecases.user.CreateUserUseCaseParams

class UserRepositoryImpl(private val userDataSource: UserDataSource): UserRepository() {
    override suspend fun createUser(createUserUseCaseParams: CreateUserUseCaseParams): Boolean {
        return userDataSource.createUser(createUserUseCaseParams);
    }
}