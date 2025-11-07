package org.demo.cmp.project.presentation.screens.login

import com.get.set.coremodule.BaseState
import com.get.set.coremodule.DataState
import com.get.set.auth.domain.models.UserModel

data class LoginScreenDataState(val userModel: UserModel?, val dataState: DataState = DataState.INITIAL): BaseState(dataState) {
}