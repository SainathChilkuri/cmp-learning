package org.demo.cmp.project.data.datasource.local_datasource

import UserEntity
import androidx.room.RoomDatabase
import org.demo.cmp.project.core.AppCustomException
import org.demo.cmp.project.core.AppDatabase
import org.demo.cmp.project.core.AppLogs

class LocalDataSourceImpl(private val appDatabase: RoomDatabase.Builder<AppDatabase>): LocalDataSource() {

    override suspend fun getLoggedInUser(): UserEntity {
        try{
            val users: List<UserEntity> =  appDatabase.build().userEntityInterface().getAllUsers()
            if(users.isNotEmpty()) {
                return users[0]
            }
            throw AppCustomException("No user found", tag = "Auth")
        }catch (e: Exception) {
            throw AppCustomException("No user found", tag = "Auth")
        }
    }

    override suspend fun saveLoggedInUser(userEntity: UserEntity): Boolean {
        try{
            appDatabase.build().userEntityInterface().deleteAllUsers();
            val result: Long =  appDatabase.build().userEntityInterface().insert(userEntity)
            if(result>=1) {
                return true;
            }
            throw AppCustomException("No user found", tag = "Auth")
        }catch (e: Exception) {
            throw AppCustomException(e.message ?:"Something went wrong", tag = "Auth")
        }
    }
}