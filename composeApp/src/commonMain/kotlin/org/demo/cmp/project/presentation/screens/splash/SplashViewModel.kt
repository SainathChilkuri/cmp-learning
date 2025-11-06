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
import com.get.set.database.core.AppDatabase

class SplashViewModel(appDatabaseBuilder: RoomDatabase.Builder<AppDatabase>) : BaseViewModel() {

    private val _navigateToLogin = MutableStateFlow(SplashScreenDataState(userModel = null, dataState = DataState.INITIAL));
    val navigateToLogin: StateFlow<SplashScreenDataState> = _navigateToLogin;

    init {
        viewModelScope.launch {
            delay(3000);
            _navigateToLogin.value = _navigateToLogin.value.copy(userModel = null, dataState = DataState.LOADING);
            val list = appDatabaseBuilder.build().getUserEntityInterface().getAllUsers();
            if(list.isNotEmpty()) {
                val user: UserTableEntity = list.first();
                val userModel = UserModel(
                     user.email?: "",
                     user.username?:"",
                    user.displayName
                )
                _navigateToLogin.value = _navigateToLogin.value.copy(userModel = userModel, dataState = DataState.SUCCESS);
            }else{
                _navigateToLogin.value = _navigateToLogin.value.copy(userModel = null, dataState = DataState.FAILED);
            }
        }


    }
}