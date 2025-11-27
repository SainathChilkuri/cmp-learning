package com.get.set.auth.domain.usecases.auth

import com.get.set.auth.domain.repositories.AuthRepository
import com.get.set.coremodule.BaseUseCase

class LogoutUseCase(private val authRepository: AuthRepository): BaseUseCase<Boolean,LogoutUseCaseParams>() {
    override suspend fun execute(params: LogoutUseCaseParams): Boolean {
        return authRepository.logout()
    }
}

class LogoutUseCaseParams {}