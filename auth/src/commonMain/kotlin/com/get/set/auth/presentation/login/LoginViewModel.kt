package com.get.set.auth.presentation.login

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import com.get.set.coremodule.AppCustomException
import com.get.set.coremodule.BaseViewModel
import com.get.set.coremodule.DataState
import com.get.set.coremodule.executeUseCase
import com.get.set.auth.domain.models.UserModel
import com.get.set.auth.domain.usecases.auth.GoogleSignInUseCase
import com.get.set.auth.domain.usecases.auth.GoogleSignInUseCaseParams
import com.get.set.coremodels.models.UserDataModel
import com.get.set.database.domain.usecases.StoreUserDataUseCase
import com.get.set.database.domain.usecases.StoreUserDataUseCaseParams
import org.demo.cmp.project.presentation.screens.login.LoginScreenDataState

class LoginViewModel(private val signInUseCase: GoogleSignInUseCase,private val storeUserDataUseCase: StoreUserDataUseCase): BaseViewModel() {


    private val loginScreenState =  MutableStateFlow<LoginScreenDataState>(
        LoginScreenDataState(
        dataState = DataState.INITIAL,
        userModel = null
    )
    );
    val loginScreenStateValue = loginScreenState;

    fun signInWithGoogle() {
        loginScreenState.value = loginScreenState.value.copy(dataState = DataState.LOADING);

        viewModelScope.launch {
            executeUseCase<GoogleSignInUseCaseParams, UserModel, AppCustomException, GoogleSignInUseCase>(
                onSuccess = {
                    loginScreenState.value = loginScreenState.value.copy(userModel = it, dataState = DataState.SUCCESS);
                    storeUserDataUseCase.execute(StoreUserDataUseCaseParams(
                        UserDataModel(
                            displayName = it.displayName,
                            email = it.email,
                            username = it.username
                        )
                    ))

                },
                onError = {
                    loginScreenState.value = loginScreenState.value.copy(dataState = DataState.FAILED);
                },
                useCase = signInUseCase,
                params = GoogleSignInUseCaseParams()

            )
        }
    }
}