package org.demo.cmp.project.di

import com.get.set.auth.domain.repositories.AuthRepository
import com.get.set.auth.domain.usecases.auth.GoogleSignInUseCase
import org.koin.dsl.module

val usecases = module {
  single {
      GoogleSignInUseCase(get<AuthRepository>())
  }
}