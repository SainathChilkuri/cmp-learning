package org.demo.cmp.project.di

import org.demo.cmp.project.data.repositories.AuthRepositoryImpl
import org.demo.cmp.project.domain.repositories.AuthRepository
import org.koin.dsl.bind
import org.koin.dsl.module

val repositories = module {
  single {
      AuthRepositoryImpl(get(),get())
  } bind AuthRepository::class
}