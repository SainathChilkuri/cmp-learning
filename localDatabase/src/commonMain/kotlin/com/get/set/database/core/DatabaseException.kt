package com.get.set.database.core

class DatabaseException(override val message: String, val tag: String): Exception() {
}