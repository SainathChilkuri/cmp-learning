package com.get.set.database.data.datasource.local_datasource

import UserTableEntity

abstract class LocalDataSource {
    abstract suspend fun getLoggedInUser(): UserTableEntity
    abstract  suspend fun saveLoggedInUser(userEntity: UserTableEntity): Boolean
    abstract  suspend fun clearAllUserData(): Boolean
}