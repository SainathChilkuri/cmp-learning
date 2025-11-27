package com.get.set.database.domain.repositories

import com.get.set.coremodels.models.UserDataModel
import com.get.set.database.domain.usecases.ClearAllUserDataUseCaseParams
import com.get.set.database.domain.usecases.FetchLoggedInUserDetailsUseCaseParams
import com.get.set.database.domain.usecases.StoreUserDataUseCaseParams

abstract class UserLocalDataRepository {
    abstract suspend fun fetchUserDetails(fetchLoggedInUserDetailsUseCaseParams: FetchLoggedInUserDetailsUseCaseParams): UserDataModel;
    abstract suspend fun storeUserDetails(storeUserDataUseCaseParams: StoreUserDataUseCaseParams): Boolean;
    abstract suspend fun clearAllUserData(clearAllUserDataUseCaseParams: ClearAllUserDataUseCaseParams): Boolean;
}