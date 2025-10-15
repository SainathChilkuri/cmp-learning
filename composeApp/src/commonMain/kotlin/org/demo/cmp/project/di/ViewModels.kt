package org.demo.cmp.project.di

import org.demo.cmp.project.presentation.screens.login.LoginViewModel
import org.demo.cmp.project.presentation.screens.splash.SplashViewModel
import org.koin.dsl.module

val viewModel = module {
  factory <SplashViewModel> {
      SplashViewModel()
  }

    factory <LoginViewModel> {
        LoginViewModel()
    }
}