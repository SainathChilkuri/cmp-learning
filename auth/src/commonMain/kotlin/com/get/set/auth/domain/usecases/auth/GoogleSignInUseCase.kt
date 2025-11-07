package com.get.set.auth.domain.usecases.auth

import com.get.set.coremodule.BaseUseCase
import com.get.set.auth.domain.models.UserModel
import com.get.set.auth.domain.repositories.AuthRepository

class GoogleSignInUseCase(private val authRepository: AuthRepository): BaseUseCase<UserModel, GoogleSignInUseCaseParams>() {
    override suspend fun execute(params: GoogleSignInUseCaseParams): UserModel {
        return authRepository.signInWithGoogle();
    }
}

class GoogleSignInUseCaseParams {

}