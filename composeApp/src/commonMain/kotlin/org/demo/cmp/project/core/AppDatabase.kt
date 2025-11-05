package org.demo.cmp.project.core

import UserEntity
import UserEntityInterface
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userEntityInterface() : UserEntityInterface
}