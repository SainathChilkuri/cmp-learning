package com.get.set.database.domain.usecases

import com.get.set.coremodels.models.UserDataModel
import com.get.set.coremodule.BaseUseCase
import com.get.set.database.domain.repositories.UserLocalDataRepository

class FetchLoggedInUserDetailsUseCase(private val userLocalDataRepository: UserLocalDataRepository): BaseUseCase<UserDataModel,FetchLoggedInUserDetailsUseCaseParams>() {
    override suspend fun execute(params: FetchLoggedInUserDetailsUseCaseParams): UserDataModel {
        return userLocalDataRepository.fetchUserDetails(params);
    }
}

class FetchLoggedInUserDetailsUseCaseParams {}