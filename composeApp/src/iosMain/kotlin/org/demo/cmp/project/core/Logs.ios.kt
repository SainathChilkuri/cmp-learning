package org.demo.cmp.project.core

import platform.Foundation.NSLog

actual object AppLogs {
    actual fun info(message: String) {
        NSLog("IOS [INFO]: $message")
    }

    actual fun warn(message: String) {
        NSLog("IOS [WARN]: $message")
    }

    actual fun error(message: String) {
        NSLog("IOS [ERROR]: $message")
    }
}