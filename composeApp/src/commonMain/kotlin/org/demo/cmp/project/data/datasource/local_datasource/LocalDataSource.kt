package org.demo.cmp.project.data.datasource.local_datasource

import UserEntity
import org.demo.cmp.project.domain.models.UserModel

abstract class LocalDataSource {
    abstract suspend fun getLoggedInUser(): UserEntity
    abstract  suspend fun saveLoggedInUser(userEntity: UserEntity): Boolean
}