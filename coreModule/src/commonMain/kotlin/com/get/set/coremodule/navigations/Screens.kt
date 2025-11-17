package com.get.set.coremodule.navigations

open class Screens(val route: String) {
    data object Splash : Screens("splash")
    data object Login : Screens("login/{{data}}") {
        fun createRoute(data: String) = "login/$data"
    }

    data object Dashboard : Screens("dashboard/{data}") {
        fun createRoute(data: String) = Screens("dashboard/$data")
    }

    data object  Task : Screens("task")
}