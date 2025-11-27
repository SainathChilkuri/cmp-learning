package com.get.set.database.data.datasource.local_datasource


import UserTableEntity
import androidx.room.RoomDatabase
import com.get.set.coremodule.AppCustomException
import com.get.set.database.core.AppDatabase
import com.get.set.database.core.DatabaseException

class LocalDataSourceImpl(private val appDatabase: RoomDatabase.Builder<AppDatabase>): LocalDataSource() {

    override suspend fun getLoggedInUser(): UserTableEntity {
        try{
            val users: List<UserTableEntity> =  appDatabase.build().getUserEntityInterface().getAllUsers()
            if(users.isNotEmpty()) {
                return users[0]
            }
            throw AppCustomException("No user found", tag = "Auth")
        }catch (e: Exception) {
            throw AppCustomException("No user found", tag = "Auth")
        }
    }

    override suspend fun saveLoggedInUser(userEntity: UserTableEntity): Boolean {
        try{
            appDatabase.build().getUserEntityInterface().deleteAllUsers();
            val result: Long =  appDatabase.build().getUserEntityInterface().insert(userEntity)
            if(result>=1) {
                return true;
            }
            throw AppCustomException("No user found", tag = "Auth")
        }catch (e: Exception) {
            throw AppCustomException(e.message ?:"Something went wrong", tag = "Auth")
        }
    }

    override suspend fun clearAllUserData(): Boolean {
        try{
            appDatabase.build().getUserEntityInterface().deleteAllUsers();
            return true
        }catch (e: Exception) {
            throw AppCustomException(e.message ?:"Something went wrong", tag = "Auth")
        }
    }
}