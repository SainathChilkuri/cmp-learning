package org.demo.cmp.project.presentation.screens.splash

import UserEntity
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewModelScope
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.demo.cmp.project.core.AppDatabase
import org.demo.cmp.project.core.AppLogs
import org.demo.cmp.project.core.BaseViewModel
import org.demo.cmp.project.core.DataState
import org.demo.cmp.project.domain.models.UserModel

class SplashViewModel(appDatabaseBuilder: RoomDatabase.Builder<AppDatabase>) : BaseViewModel() {

    private val _navigateToLogin = MutableStateFlow(SplashScreenDataState(userModel = null, dataState = DataState.INITIAL));
    val navigateToLogin: StateFlow<SplashScreenDataState> = _navigateToLogin;

    init {
        viewModelScope.launch {
            delay(3000);
            _navigateToLogin.value = _navigateToLogin.value.copy(userModel = null, dataState = DataState.LOADING);
            val list = appDatabaseBuilder.build().userEntityInterface().getAllUsers();
            AppLogs.info("Users--->${list}","User")
            if(list.isNotEmpty()) {
                val user: UserEntity = list.first();
                val userModel = UserModel(
                     user.email?: "",
                     user.username?:"",
                    user.displayName
                )
                _navigateToLogin.value = _navigateToLogin.value.copy(userModel = userModel, dataState = DataState.SUCCESS);
                AppLogs.info("Users---> Data---->${_navigateToLogin.value.userModel}","User")
            }else{
                _navigateToLogin.value = _navigateToLogin.value.copy(userModel = null, dataState = DataState.FAILED);
            }
        }


    }
}