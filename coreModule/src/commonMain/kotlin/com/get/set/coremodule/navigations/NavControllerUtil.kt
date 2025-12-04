package com.get.set.coremodule.navigations

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.snapshots.SnapshotStateList


var Navigator = compositionLocalOf<SnapshotStateList<Screens>> {
    error("No NavController provided")
}

object NavigatorUtil{

    lateinit var navHostController: SnapshotStateList<Screens>

    fun pushNamed(screens: Screens) {
        navHostController.add(screens);
    }

    fun pop() {
        navHostController.removeLast();
    }


    fun pushNamedAndRemoveUntil(screens: Screens, uptoScreen: Screens?=null) {
        val stack = navHostController

        if (uptoScreen == null) {
            stack.clear()
            stack.add(screens)
        } else {
            while (stack.isNotEmpty() && stack.last() != uptoScreen) {
                stack.removeLast()
            }
            // Now add the new screen
            stack.add(screens)
        }
        navHostController = stack;
    }


    fun popUntil(screens: Screens) {
        val stack = navHostController;
            while(stack.last() != screens && navHostController.isNotEmpty()) {
                navHostController.removeLast()
            }
    }
}

