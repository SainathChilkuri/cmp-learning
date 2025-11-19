package org.demo.cmp.project.presentation.screens.login

import com.get.set.coremodule.BaseState
import com.get.set.coremodule.DataState
import com.get.set.auth.domain.models.UserModel
import com.get.set.coremodels.models.UserDataModel

data class LoginScreenDataState(val userModel: UserDataModel?, val dataState: DataState = DataState.INITIAL): BaseState(dataState) {
}