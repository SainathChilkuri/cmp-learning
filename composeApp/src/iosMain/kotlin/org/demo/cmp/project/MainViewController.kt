package org.demo.cmp.project

import androidx.compose.ui.window.ComposeUIViewController
import org.demo.cmp.project.di.Koin

fun MainViewController() = ComposeUIViewController {
    Koin.initKoin()
    App()
}