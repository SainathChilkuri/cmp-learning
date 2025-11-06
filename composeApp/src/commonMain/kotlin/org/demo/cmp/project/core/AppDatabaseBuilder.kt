

package org.demo.cmp.project.core

import androidx.room.RoomDatabase
import com.get.set.database.core.AppDatabase

expect object  AppDatabaseBuilder {
     fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase>
}