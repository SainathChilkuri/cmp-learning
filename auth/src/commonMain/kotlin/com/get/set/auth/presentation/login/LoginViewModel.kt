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
import com.get.set.firebasedatasource.domain.usecases.user.CreateUserUseCase
import com.get.set.firebasedatasource.domain.usecases.user.CreateUserUseCaseParams
import org.demo.cmp.project.presentation.screens.login.LoginScreenDataState

class LoginViewModel(private val signInUseCase: GoogleSignInUseCase,private val storeUserDataUseCase: StoreUserDataUseCase, private val createUserUseCase: CreateUserUseCase): BaseViewModel() {


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
                    createUser(it);
                },
                onError = {
                    loginScreenState.value = loginScreenState.value.copy(dataState = DataState.FAILED);
                },
                useCase = signInUseCase,
                params = GoogleSignInUseCaseParams()

            )
        }
    }

    private suspend fun createUser(userModel: UserModel) {
        viewModelScope.launch {
            executeUseCase<CreateUserUseCaseParams, Boolean, AppCustomException, CreateUserUseCase>(
                onSuccess = {
                        storeUserDataUseCase.execute(StoreUserDataUseCaseParams(
                            UserDataModel(
                                displayName = userModel.displayName,
                                email = userModel.email,
                                username = userModel.username
                            )
                        ))
                        loginScreenState.value = loginScreenState.value.copy(userModel = userModel, dataState = DataState.SUCCESS);
                },
                onError = {
                    loginScreenState.value = loginScreenState.value.copy(dataState = DataState.FAILED);
                },
                useCase = createUserUseCase,
                params = CreateUserUseCaseParams(
                    email = userModel.email,
                    displayName = userModel.displayName,
                    userName = userModel.username
                )

            )
        }
    }
}