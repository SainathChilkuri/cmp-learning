package org.demo.cmp.project.di

import com.get.set.auth.domain.usecases.auth.GoogleSignInUseCase
import com.get.set.taskmanagement.presentation.bottom_bar_page_view.BottomBarPageViewModel
import com.get.set.auth.presentation.login.LoginViewModel
import com.get.set.taskmanagement.presentation.bottom_nav_bar.BottomNavBarViewModel
import com.get.set.taskmanagement.presentation.dashboard.DashboardViewModel
import com.get.set.taskmanagement.presentation.task.TaskViewModel
import org.demo.cmp.project.presentation.screens.splash.SplashViewModel
import org.koin.dsl.module

val viewModel = module {
  factory <SplashViewModel> {
      SplashViewModel(get())
  }

    factory <LoginViewModel> {
        LoginViewModel(get<GoogleSignInUseCase>(), get(), get())
    }

    factory <DashboardViewModel> {
        DashboardViewModel()
    }

    factory <BottomBarPageViewModel> {
        BottomBarPageViewModel(get())
    }

    factory <BottomNavBarViewModel> {
        BottomNavBarViewModel()
    }

    factory <TaskViewModel> {
        TaskViewModel(get())
    }
}