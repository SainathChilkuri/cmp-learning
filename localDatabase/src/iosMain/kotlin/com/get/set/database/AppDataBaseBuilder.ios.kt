package com.get.set.database

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.get.set.database.core.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSHomeDirectory


fun buildIosDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
        val dbFile = NSHomeDirectory() + "/app_db.db"
        return Room.databaseBuilder<AppDatabase>(
            name = dbFile,
//            factory = { AppDatabase_Impl() } // This too will show error
        )
            .fallbackToDestructiveMigrationOnDowngrade(true)
            .setDriver(BundledSQLiteDriver()) // Very important
            .setQueryCoroutineContext(Dispatchers.IO)
    }
