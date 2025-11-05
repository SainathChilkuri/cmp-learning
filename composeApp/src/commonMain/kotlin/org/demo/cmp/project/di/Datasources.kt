package org.demo.cmp.project.di

import androidx.room.RoomDatabase
import org.demo.cmp.project.core.AppDatabase
import org.demo.cmp.project.core.AppDatabaseBuilder
import org.demo.cmp.project.data.datasource.local_datasource.LocalDataSource
import org.demo.cmp.project.data.datasource.local_datasource.LocalDataSourceImpl
import org.demo.cmp.project.data.datasource.remote_datasource.auth.AuthDataSource
import org.demo.cmp.project.data.datasource.remote_datasource.auth.AuthDatasourceImpl
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
}