package org.demo.cmp.project.presentation.navigations

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


var Navigator = compositionLocalOf<NavHostController> {
    error("No NavController provided")
}