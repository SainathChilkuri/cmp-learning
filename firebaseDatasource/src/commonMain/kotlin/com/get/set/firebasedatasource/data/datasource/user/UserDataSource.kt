package com.get.set.firebasedatasource.data.datasource.user

import com.get.set.coremodels.models.UserDataModel
import com.get.set.firebasedatasource.domain.usecases.user.CreateUserUseCaseParams

abstract class UserDataSource {
    abstract suspend fun createUser(createUserUseCaseParams: CreateUserUseCaseParams): UserDataModel
}