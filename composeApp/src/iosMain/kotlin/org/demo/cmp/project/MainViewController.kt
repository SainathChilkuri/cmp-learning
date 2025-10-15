package org.demo.cmp.project

import androidx.compose.ui.window.ComposeUIViewController
import org.demo.cmp.project.di.Koin
import org.demo.cmp.project.presentation.App

fun MainViewController() = ComposeUIViewController {
    Koin.initKoin()
    App()
}