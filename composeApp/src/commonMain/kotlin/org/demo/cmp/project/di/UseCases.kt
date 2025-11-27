package org.demo.cmp.project.di

import com.get.set.auth.domain.repositories.AuthRepository
import com.get.set.auth.domain.usecases.auth.GoogleSignInUseCase
import com.get.set.auth.domain.usecases.auth.LogoutUseCase
import com.get.set.database.domain.usecases.ClearAllUserDataUseCase
import com.get.set.database.domain.usecases.FetchLoggedInUserDetailsUseCase
import com.get.set.database.domain.usecases.StoreUserDataUseCase
import com.get.set.firebasedatasource.domain.usecases.task.CreateTaskUseCase
import com.get.set.firebasedatasource.domain.usecases.task.FetchTaskWithDateUseCase
import com.get.set.firebasedatasource.domain.usecases.user.CreateUserUseCase
import org.koin.dsl.module

val usecases = module {
  single {
      GoogleSignInUseCase(get<AuthRepository>())
  }

    single {
        FetchLoggedInUserDetailsUseCase(get())
    }

    single {
        StoreUserDataUseCase(get())
    }

    single {
        CreateUserUseCase(get())
    }

    single {
        CreateTaskUseCase(get())
    }

    single {
        FetchTaskWithDateUseCase(get())
    }

    single {
        LogoutUseCase(get())
    }

    single {
        ClearAllUserDataUseCase(get())
    }
}