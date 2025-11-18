package org.demo.cmp.project.di

import com.get.set.auth.data.repositories.AuthRepositoryImpl
import com.get.set.auth.domain.repositories.AuthRepository
import com.get.set.database.data.repositories.UserLocalDataRepositoryImpl
import com.get.set.database.domain.repositories.UserLocalDataRepository
import com.get.set.firebasedatasource.data.repository.TaskRepositoryImpl
import com.get.set.firebasedatasource.data.repository.UserRepositoryImpl
import com.get.set.firebasedatasource.domain.repository.TaskRepository
import com.get.set.firebasedatasource.domain.repository.UserRepository
import org.koin.dsl.bind
import org.koin.dsl.module

val repositories = module {
  single {
      AuthRepositoryImpl(get())
  } bind AuthRepository::class

    single {
        UserLocalDataRepositoryImpl(get())
    } bind UserLocalDataRepository::class

    single {
        UserRepositoryImpl(get())
    } bind UserRepository::class

    single {
        TaskRepositoryImpl(get())
    } bind TaskRepository::class
}