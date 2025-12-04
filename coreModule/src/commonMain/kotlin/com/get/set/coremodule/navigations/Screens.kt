package com.get.set.coremodule.navigations

import androidx.navigation3.runtime.NavKey
import com.get.set.coremodels.models.UserDataModel
import kotlinx.serialization.Serializable

@Serializable
sealed interface Screens: NavKey {

    @Serializable
    data object Splash : Screens

    @Serializable
    data object Login : Screens


    @Serializable
    data class Dashboard(val userDataModel: UserDataModel) : Screens


    @Serializable
    data class Task(val userDataModel: UserDataModel) : Screens
}