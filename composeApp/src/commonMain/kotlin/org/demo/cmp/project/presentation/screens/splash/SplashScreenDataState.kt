package org.demo.cmp.project.presentation.screens.splash

import com.get.set.coremodule.BaseState
import com.get.set.coremodule.DataState
import com.get.set.auth.domain.models.UserModel

data class SplashScreenDataState(val userModel: UserModel?, val dataState: DataState): BaseState(dataState = dataState) {
}
