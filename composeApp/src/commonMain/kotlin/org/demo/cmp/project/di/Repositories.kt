package org.demo.cmp.project.di

import com.get.set.auth.domain.repositories.AuthRepository
import org.koin.dsl.bind
import org.koin.dsl.module

val repositories = module {
  single {
      AuthRepositoryImpl(get(),get())
  } bind AuthRepository::class
}