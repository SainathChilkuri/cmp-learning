package org.demo.cmp.project.di

import androidx.room.RoomDatabase
import com.get.set.database.core.AppDatabase
import com.get.set.database.data.datasource.local_datasource.LocalDataSource
import com.get.set.database.data.datasource.local_datasource.LocalDataSourceImpl
import org.demo.cmp.project.core.AppDatabaseBuilder
import com.get.set.auth.data.datasource.remote_datasource.auth.AuthDataSource
import com.get.set.auth.data.datasource.remote_datasource.auth.AuthDatasourceImpl
import org.demo.cmp.project.core.GoogleSignInUtil
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
        AuthDatasourceImpl()
    } bind AuthDataSource::class

    single {
        GoogleSignInUtil()
    }
}