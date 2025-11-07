package org.demo.cmp.project.di

import com.get.set.auth.data.repositories.AuthRepositoryImpl
import com.get.set.auth.domain.repositories.AuthRepository
import com.get.set.database.data.repositories.UserLocalDataRepositoryImpl
import com.get.set.database.domain.repositories.UserLocalDataRepository
import org.koin.dsl.bind
import org.koin.dsl.module

val repositories = module {
  single {
      AuthRepositoryImpl(get())
  } bind AuthRepository::class

    single {
        UserLocalDataRepositoryImpl(get())
    } bind UserLocalDataRepository::class
}