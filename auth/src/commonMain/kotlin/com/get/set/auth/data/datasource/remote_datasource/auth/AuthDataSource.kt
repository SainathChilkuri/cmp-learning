package com.get.set.auth.data.datasource.remote_datasource.auth

import com.get.set.auth.data.entity.UserEntity

abstract class AuthDataSource {
    abstract suspend fun signInWithGoogle(): UserEntity
    abstract suspend fun logout(): Boolean
}