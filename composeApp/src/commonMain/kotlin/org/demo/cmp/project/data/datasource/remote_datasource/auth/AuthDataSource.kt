package org.demo.cmp.project.data.datasource.remote_datasource.auth

import UserEntity
import org.demo.cmp.project.domain.models.GoogleAccountData

abstract class AuthDataSource {
    abstract suspend fun signInWithGoogle(): UserEntity
}