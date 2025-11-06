package com.get.set.database.data.datasource.local_datasource


import UserTableEntity
import androidx.room.RoomDatabase
import com.get.set.database.core.AppDatabase
import com.get.set.database.core.DatabaseException

class LocalDataSourceImpl(private val appDatabase: RoomDatabase.Builder<AppDatabase>): LocalDataSource() {

    override suspend fun getLoggedInUser(): UserTableEntity {
        try{
            val users: List<UserTableEntity> =  appDatabase.build().getUserEntityInterface().getAllUsers()
            if(users.isNotEmpty()) {
                return users[0]
            }
            throw DatabaseException("No user found", tag = "Auth")
        }catch (e: Exception) {
            throw DatabaseException("No user found", tag = "Auth")
        }
    }

    override suspend fun saveLoggedInUser(userEntity: UserTableEntity): Boolean {
        try{
            appDatabase.build().getUserEntityInterface().deleteAllUsers();
            val result: Long =  appDatabase.build().getUserEntityInterface().insert(userEntity)
            if(result>=1) {
                return true;
            }
            throw DatabaseException("No user found", tag = "Auth")
        }catch (e: Exception) {
            throw DatabaseException(e.message ?:"Something went wrong", tag = "Auth")
        }
    }
}