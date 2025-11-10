package org.demo.cmp.project.di

import androidx.room.RoomDatabase
import com.get.set.database.core.AppDatabase
import com.get.set.database.data.datasource.local_datasource.LocalDataSource
import com.get.set.database.data.datasource.local_datasource.LocalDataSourceImpl
import org.demo.cmp.project.core.AppDatabaseBuilder
import com.get.set.auth.data.datasource.remote_datasource.auth.AuthDataSource
import com.get.set.auth.data.datasource.remote_datasource.auth.AuthDatasourceImpl
import com.get.set.firebasedatasource.data.datasource.user.UserDataSource
import com.get.set.firebasedatasource.data.datasource.user.UserDataSourceImpl
import com.get.set.firebasedatasource.domain.repository.UserRepository
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore
import org.demo.cmp.project.core.GoogleSignInUtility
import org.koin.dsl.bind
import org.koin.dsl.module

val datasources = module {
    single <RoomDatabase.Builder<AppDatabase>>{
        AppDatabaseBuilder.getDatabaseBuilder()
    }
    single<LocalDataSource> {
        LocalDataSourceImpl(get())
    } bind LocalDataSource::class

    single<AuthDataSource> {
        AuthDatasourceImpl(GoogleSignInUtility.instance())
    } bind AuthDataSource::class

    single<UserDataSource> {
        UserDataSourceImpl(Firebase.firestore)
    } bind UserDataSource::class
}