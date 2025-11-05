package org.demo.cmp.project.presentation.screens.splash

import org.demo.cmp.project.core.BaseState
import org.demo.cmp.project.core.DataState
import org.demo.cmp.project.domain.models.UserModel

data class SplashScreenDataState(val userModel: UserModel?, val dataState: DataState): BaseState(dataState = dataState) {
}
