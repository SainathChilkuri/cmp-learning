package com.get.set.firebasedatasource.domain.usecases.user

import com.get.set.coremodule.BaseUseCase
import com.get.set.firebasedatasource.domain.repository.UserRepository
import kotlinx.serialization.Serializable

class CreateUserUseCase(private val userRepository: UserRepository): BaseUseCase<Boolean, CreateUserUseCaseParams>() {

    override suspend fun execute(params: CreateUserUseCaseParams): Boolean {
       return userRepository.createUser(params);
    }
}

@Serializable
data class CreateUserUseCaseParams(val email: String, val displayName: String, val userName: String) {
}