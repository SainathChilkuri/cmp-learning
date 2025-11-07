package com.get.set.coremodule.navigations

sealed class Screens(val route: String) {
    data object Splash : Screens("splash")
    data object Login : Screens("login/{{data}}") {
        fun createRoute(data: String) = "login/$data"
    }

    data object Dashboard : Screens("dashboard") {
        fun createRoute(data: String) = "dashboard"
    }
}