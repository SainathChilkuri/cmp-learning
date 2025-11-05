package org.demo.cmp.project.di

import org.demo.cmp.project.domain.repositories.AuthRepository
import org.demo.cmp.project.domain.usecases.auth.GoogleSignInUseCase
import org.koin.dsl.module

val usecases = module {
  single {
      GoogleSignInUseCase(get<AuthRepository>())
  }
}