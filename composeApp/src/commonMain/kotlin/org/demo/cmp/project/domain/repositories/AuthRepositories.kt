package org.demo.cmp.project.domain.repositories

import UserEntity
import org.demo.cmp.project.domain.models.GoogleAccountData
import org.demo.cmp.project.domain.models.UserModel

abstract class AuthRepository {
    abstract suspend fun signInWithGoogle(): UserModel
}