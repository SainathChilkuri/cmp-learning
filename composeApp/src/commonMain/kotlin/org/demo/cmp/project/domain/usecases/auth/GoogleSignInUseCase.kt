package org.demo.cmp.project.domain.usecases.auth

import org.demo.cmp.project.core.BaseUseCase
import org.demo.cmp.project.domain.models.UserModel
import org.demo.cmp.project.domain.repositories.AuthRepository

class GoogleSignInUseCase(private val authRepository: AuthRepository): BaseUseCase<UserModel, GoogleSignInUseCaseParams>() {
    override suspend fun execute(params: GoogleSignInUseCaseParams): UserModel {
        return authRepository.signInWithGoogle();
    }
}

class GoogleSignInUseCaseParams {

}