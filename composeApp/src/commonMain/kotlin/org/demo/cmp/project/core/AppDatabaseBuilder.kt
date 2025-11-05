@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package org.demo.cmp.project.core

import androidx.room.RoomDatabase

expect object  AppDatabaseBuilder {
    fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase>
}