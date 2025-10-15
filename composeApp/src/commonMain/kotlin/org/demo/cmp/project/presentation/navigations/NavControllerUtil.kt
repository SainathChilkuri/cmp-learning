package org.demo.cmp.project.presentation.navigations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController


var Navigator = compositionLocalOf<NavHostController> {
    error("No NavController provided")
}

object NavigatorUtil{

    @Composable
    fun PushNamed(screens: Screens) {
        Navigator.current.navigate(screens.route);
    }

    @Composable
    fun Pop() {
        Navigator.current.popBackStack();
    }

    @Composable
    fun PushNamedAndRemoveUntil(screens: Screens, uptoScreen: Screens?) {
        Navigator.current.navigate(screens.route) {
            uptoScreen?.let {
                popUpTo(uptoScreen.route) {
                    inclusive = true
                }
            }
        };
    }

    @Composable
    fun PopUntil(screens: Screens) {
        Navigator.current.popBackStack(screens.route,inclusive = true);
    }
}

