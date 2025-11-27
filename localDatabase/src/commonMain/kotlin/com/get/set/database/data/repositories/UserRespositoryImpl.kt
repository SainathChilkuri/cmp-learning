package com.get.set.database.data.repositories

import UserTableEntity
import com.get.set.coremodels.models.UserDataModel
import com.get.set.database.data.datasource.local_datasource.LocalDataSource
import com.get.set.database.domain.repositories.UserLocalDataRepository
import com.get.set.database.domain.usecases.ClearAllUserDataUseCaseParams
import com.get.set.database.domain.usecases.FetchLoggedInUserDetailsUseCaseParams
import com.get.set.database.domain.usecases.StoreUserDataUseCaseParams

class UserLocalDataRepositoryImpl(private val localDataSource: LocalDataSource): UserLocalDataRepository() {

    override suspend fun fetchUserDetails(fetchLoggedInUserDetailsUseCaseParams: FetchLoggedInUserDetailsUseCaseParams): UserDataModel {
        val userEntity :UserTableEntity =  localDataSource.getLoggedInUser();
        return UserDataModel(
            displayName = userEntity.displayName,
            email = userEntity.email,
            username = userEntity.username,
            userId = userEntity.userId
        )
    }

    override suspend fun storeUserDetails(storeUserDataUseCaseParams: StoreUserDataUseCaseParams): Boolean {
        val userTableEntity: UserTableEntity = UserTableEntity(
            displayName = storeUserDataUseCaseParams.userDataModel.displayName?: "",
            email = storeUserDataUseCaseParams.userDataModel.email?: "",
            username = storeUserDataUseCaseParams.userDataModel.username,
            userId = storeUserDataUseCaseParams.userDataModel.userId
        )
        val result : Boolean =  localDataSource.saveLoggedInUser(userEntity = userTableEntity);
        return result;
    }

    override suspend fun clearAllUserData(clearAllUserDataUseCaseParams: ClearAllUserDataUseCaseParams): Boolean {
        return localDataSource.clearAllUserData()
    }
}