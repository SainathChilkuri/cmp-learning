package com.get.set.database.core

import UserEntityInterface
import UserTableEntity
import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [UserTableEntity::class],version = 1,)
abstract class AppDatabase: RoomDatabase() {
    abstract  fun getUserEntityInterface(): UserEntityInterface
}