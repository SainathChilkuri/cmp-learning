package com.get.set.auth.presentation.profile

import com.get.set.auth.domain.usecases.auth.LogoutUseCase
import com.get.set.auth.domain.usecases.auth.LogoutUseCaseParams
import com.get.set.coremodule.AppCustomException
import com.get.set.coremodule.AppLogs
import com.get.set.coremodule.BasePage
import com.get.set.coremodule.BaseViewModel
import com.get.set.coremodule.DataState
import com.get.set.coremodule.executeUseCase
import com.get.set.database.domain.usecases.ClearAllUserDataUseCase
import com.get.set.database.domain.usecases.ClearAllUserDataUseCaseParams
import kotlinx.coroutines.flow.MutableStateFlow

class ProfileViewModel(private val logoutUseCase: LogoutUseCase, private val clearAllUserDataUseCase: ClearAllUserDataUseCase): BaseViewModel() {

    private val profileScreenState = MutableStateFlow(ProfileScreenState())

    var profileScreenStateValue = profileScreenState


    suspend fun logoutUser() {
        profileScreenState.value = profileScreenState.value.copy(dataState = DataState.LOADING)
        executeUseCase<LogoutUseCaseParams, Boolean, AppCustomException, LogoutUseCase>(
            useCase = logoutUseCase,
            onSuccess =  {
                clearAllUserData()
            },
            onError = {
                AppLogs.error("Error--->${it.message}","Error Logout")
                profileScreenState.value = profileScreenState.value.copy(dataState = DataState.FAILED)

            },
            params = LogoutUseCaseParams()
        )
    }

    private suspend fun clearAllUserData() {
        executeUseCase<ClearAllUserDataUseCaseParams, Boolean, AppCustomException, ClearAllUserDataUseCase>(
            useCase = clearAllUserDataUseCase,
            onSuccess =  {
                profileScreenState.value = profileScreenState.value.copy(dataState = DataState.SUCCESS)
            },
            onError = {
                AppLogs.error("Error---> Clear ${it.message}","Error Logout")
                profileScreenState.value = profileScreenState.value.copy(dataState = DataState.FAILED)
            },
            params = ClearAllUserDataUseCaseParams()
        )
    }
}