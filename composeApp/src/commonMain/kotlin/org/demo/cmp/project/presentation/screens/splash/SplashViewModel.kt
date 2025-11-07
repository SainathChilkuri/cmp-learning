package org.demo.cmp.project.presentation.screens.splash

import UserTableEntity
import androidx.lifecycle.viewModelScope
import androidx.room.RoomDatabase
import com.get.set.auth.data.entity.UserEntity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.get.set.coremodule.AppLogs
import com.get.set.coremodule.BaseViewModel
import com.get.set.coremodule.DataState
import com.get.set.auth.domain.models.UserModel
import com.get.set.coremodels.models.UserDataModel
import com.get.set.coremodule.AppCustomException
import com.get.set.coremodule.executeUseCase
import com.get.set.database.core.AppDatabase
import com.get.set.database.domain.usecases.FetchLoggedInUserDetailsUseCase
import com.get.set.database.domain.usecases.FetchLoggedInUserDetailsUseCaseParams

class SplashViewModel(private val fetchLoggedInUserDetailsUseCase: FetchLoggedInUserDetailsUseCase) : BaseViewModel() {

    private val _navigateToLogin = MutableStateFlow(SplashScreenDataState(userModel = null, dataState = DataState.INITIAL));
    val navigateToLogin: StateFlow<SplashScreenDataState> = _navigateToLogin;

    init {
        viewModelScope.launch {
            delay(3000);
            _navigateToLogin.value = _navigateToLogin.value.copy(userModel = null, dataState = DataState.LOADING);
            executeUseCase<FetchLoggedInUserDetailsUseCaseParams, UserDataModel,AppCustomException,FetchLoggedInUserDetailsUseCase>(
                useCase = fetchLoggedInUserDetailsUseCase,
                params = FetchLoggedInUserDetailsUseCaseParams(),
                onSuccess = {
                    val userModel = UserModel(
                        it.email?:"",
                        it.username?:"",
                        it.displayName?:""
                    )
                    _navigateToLogin.value = _navigateToLogin.value.copy(userModel = userModel, dataState = DataState.SUCCESS);
                },
                onError = {
                    _navigateToLogin.value = _navigateToLogin.value.copy(userModel = null, dataState = DataState.FAILED);
                }
            )
        }


    }
}