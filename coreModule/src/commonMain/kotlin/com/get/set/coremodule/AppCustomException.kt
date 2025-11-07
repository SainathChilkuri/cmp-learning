package com.get.set.coremodule

data class AppCustomException(override val message: String, val tag: String = "AppCustomException" ): Exception() {
    init {
        AppLogs.error(message, tag)
    }
}