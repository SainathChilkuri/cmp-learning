package org.demo.cmp.project.di

import org.demo.cmp.project.domain.usecases.auth.GoogleSignInUseCase
import org.demo.cmp.project.presentation.screens.dashboard.DashboardViewModel
import org.demo.cmp.project.presentation.screens.login.LoginViewModel
import org.demo.cmp.project.presentation.screens.splash.SplashViewModel
import org.koin.dsl.module

val viewModel = module {
  factory <SplashViewModel> {
      SplashViewModel(get())
  }

    factory <LoginViewModel> {
        LoginViewModel(get<GoogleSignInUseCase>())
    }

    factory <DashboardViewModel> {
        DashboardViewModel()
    }
}