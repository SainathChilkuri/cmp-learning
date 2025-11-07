package com.get.set.database.domain.usecases

import com.get.set.coremodels.models.UserDataModel
import com.get.set.coremodule.BaseUseCase
import com.get.set.database.domain.repositories.UserLocalDataRepository

class StoreUserDataUseCase(private val userLocalDataRepository: UserLocalDataRepository): BaseUseCase<Boolean, StoreUserDataUseCaseParams>() {
    override suspend fun execute(params: StoreUserDataUseCaseParams): Boolean {
        return userLocalDataRepository.storeUserDetails(params)
    }
}

class StoreUserDataUseCaseParams(val userDataModel: UserDataModel){

}