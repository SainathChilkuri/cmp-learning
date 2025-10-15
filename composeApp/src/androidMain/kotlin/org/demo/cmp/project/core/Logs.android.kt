package org.demo.cmp.project.core

import android.util.Log

actual object AppLogs {
    actual fun info(message: String) {
        Log.i("INFO",message)
    }

    actual fun warn(message: String) {
        Log.w("WARN",message)
    }

    actual fun error(message: String) {
        Log.e("ERROR",message)
    }

}