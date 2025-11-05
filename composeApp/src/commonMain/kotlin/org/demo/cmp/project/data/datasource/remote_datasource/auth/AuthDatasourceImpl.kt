package org.demo.cmp.project.data.datasource.remote_datasource.auth

import UserEntity
import org.demo.cmp.project.core.AppCustomException
import org.demo.cmp.project.core.GoogleSignInUtil
import org.demo.cmp.project.domain.models.GoogleAccountData

class AuthDatasourceImpl: AuthDataSource() {
    override suspend fun signInWithGoogle(): UserEntity {
        try{
             val data: GoogleAccountData? = GoogleSignInUtil.signIn();
            if(data?.email != null) {
                return  UserEntity(
                    username = data.username,
                    displayName = data.displayName ?: "",
                    email = data.email ?: ""
                )
            }
            throw AppCustomException("Unable to sign in with google", tag = "Auth")
        }catch (e: Exception) {
            throw AppCustomException(e.message?:e.toString(), tag = "Auth")
        }
    }
}