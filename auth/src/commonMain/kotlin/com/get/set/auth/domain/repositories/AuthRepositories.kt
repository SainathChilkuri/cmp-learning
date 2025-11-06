package com.get.set.auth.domain.repositories

import com.get.set.auth.domain.models.UserModel

abstract class AuthRepository {
    abstract suspend fun signInWithGoogle(): UserModel
}