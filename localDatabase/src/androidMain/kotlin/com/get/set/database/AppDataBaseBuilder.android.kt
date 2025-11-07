package com.get.set.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.get.set.database.core.AppDatabase
import kotlinx.coroutines.Dispatchers

fun buildDatabaseBuilder(context: Context): RoomDatabase.Builder<AppDatabase> {
        val dbFile = context.getDatabasePath("app_db.db")
        return Room.databaseBuilder<AppDatabase>(
            context = context.applicationContext,
            name = dbFile.absolutePath
        )
            .fallbackToDestructiveMigrationOnDowngrade(true)
            .setDriver(BundledSQLiteDriver()) // Very important
            .setQueryCoroutineContext(Dispatchers.IO)
 }
