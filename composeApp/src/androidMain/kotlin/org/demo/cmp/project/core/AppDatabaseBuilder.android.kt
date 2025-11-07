package org.demo.cmp.project.core

import androidx.room.RoomDatabase
import com.get.set.database.core.AppDatabase
import com.get.set.database.buildDatabaseBuilder
import org.demo.cmp.project.MainActivity.Companion.appContext

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual object AppDatabaseBuilder {
    actual fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
        return buildDatabaseBuilder(appContext);
    }
}