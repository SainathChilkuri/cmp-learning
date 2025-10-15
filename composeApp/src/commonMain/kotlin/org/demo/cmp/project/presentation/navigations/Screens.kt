package org.demo.cmp.project.presentation.navigations

sealed class Screens(val route: String) {
    data object Splash : Screens("splash")
    data object Login : Screens("login/{{data}}") {
        fun createRoute(data: String) = "login/$data"
    }
}