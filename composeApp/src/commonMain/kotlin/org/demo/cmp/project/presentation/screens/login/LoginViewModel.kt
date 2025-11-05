package org.demo.cmp.project.presentation.screens.login

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.demo.cmp.project.core.AppCustomException
import org.demo.cmp.project.core.BaseViewModel
import org.demo.cmp.project.core.DataState
import org.demo.cmp.project.core.executeUseCase
import org.demo.cmp.project.domain.models.UserModel
import org.demo.cmp.project.domain.usecases.auth.GoogleSignInUseCase
import org.demo.cmp.project.domain.usecases.auth.GoogleSignInUseCaseParams

class LoginViewModel(private val signInUseCase: GoogleSignInUseCase): BaseViewModel() {


    private val loginScreenState =  MutableStateFlow<LoginScreenDataState>(LoginScreenDataState(
        dataState = DataState.INITIAL,
        userModel = null
    ));
    val loginScreenStateValue = loginScreenState;

    fun signInWithGoogle() {
        loginScreenState.value = loginScreenState.value.copy(dataState = DataState.LOADING);

        viewModelScope.launch {
            executeUseCase<GoogleSignInUseCaseParams,UserModel,AppCustomException,GoogleSignInUseCase>(
                onSuccess = {
                    loginScreenState.value = loginScreenState.value.copy(userModel = it, dataState = DataState.SUCCESS);

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