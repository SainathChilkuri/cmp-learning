package org.demo.cmp.project.core

import androidx.room.RoomDatabase
import com.get.set.database.buildIosDatabaseBuilder
import com.get.set.database.core.AppDatabase


actual object AppDatabaseBuilder {
    actual suspend fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
        return buildIosDatabaseBuilder()
    }
}