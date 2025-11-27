package com.get.set.auth.presentation.profile

import com.get.set.coremodule.BaseState
import com.get.set.coremodule.DataState

data class ProfileScreenState(val dataState: DataState = DataState.INITIAL): BaseState(dataState) {

}