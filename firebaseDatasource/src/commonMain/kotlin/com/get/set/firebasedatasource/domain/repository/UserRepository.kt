package com.get.set.firebasedatasource.domain.repository

import com.get.set.firebasedatasource.domain.usecases.user.CreateUserUseCaseParams

abstract class UserRepository {
    abstract suspend fun createUser(createUserUseCaseParams: CreateUserUseCaseParams): Boolean
}