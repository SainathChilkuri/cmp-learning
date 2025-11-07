package com.get.set.coremodule

import platform.Foundation.NSLog

actual object AppLogs {
    actual fun info(message: String, tag: String) {
        NSLog("INFO [${tag}]: $message")
    }

    actual fun warn(message: String, tag: String) {
        NSLog("WARN [${tag}]: $message")
    }

    actual fun error(message: String, tag: String) {
        NSLog("ERROR [${tag}]: $message")
    }
}