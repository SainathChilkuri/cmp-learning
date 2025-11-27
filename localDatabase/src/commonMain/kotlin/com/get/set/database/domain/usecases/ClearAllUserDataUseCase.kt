package com.get.set.database.domain.usecases

import com.get.set.coremodule.BaseUseCase
import com.get.set.database.domain.repositories.UserLocalDataRepository

class ClearAllUserDataUseCase(private val userLocalDataRepository: UserLocalDataRepository): BaseUseCase<Boolean,ClearAllUserDataUseCaseParams>() {
    override suspend fun execute(params: ClearAllUserDataUseCaseParams): Boolean {
        return userLocalDataRepository.clearAllUserData(params)
    }
}

class ClearAllUserDataUseCaseParams {}