package com.get.set.coremodule.navigations

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController


var Navigator = compositionLocalOf<NavHostController> {
    error("No NavController provided")
}

object NavigatorUtil{

    lateinit var navHostController: NavHostController

    fun pushNamed(screens: Screens) {
        navHostController.navigate(screens.route);
    }

    fun pop() {
        navHostController.popBackStack();
    }


    fun pushNamedAndRemoveUntil(screens: Screens, uptoScreen: Screens?) {
        navHostController.navigate(screens.route) {
            uptoScreen?.let {
                popUpTo(uptoScreen.route) {
                    inclusive = true
                }
            }
        };
    }


    fun popUntil(screens: Screens) {
        navHostController.popBackStack(screens.route,inclusive = true);
    }
}

