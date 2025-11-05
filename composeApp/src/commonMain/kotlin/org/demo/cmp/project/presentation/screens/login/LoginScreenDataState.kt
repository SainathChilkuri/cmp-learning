package org.demo.cmp.project.presentation.screens.login

import org.demo.cmp.project.core.BaseState
import org.demo.cmp.project.core.DataState
import org.demo.cmp.project.domain.models.UserModel

data class LoginScreenDataState(val userModel: UserModel?, val dataState: DataState = DataState.INITIAL): BaseState(dataState) {
}