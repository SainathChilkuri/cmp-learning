package org.demo.cmp.project.core

import android.util.Log

actual object AppLogs {
    actual fun info(message: String, tag: String) {
        Log.i("INFO [${tag}]",message)
    }

    actual fun warn(message: String,tag: String) {
        Log.w("WARN [${tag}",message)
    }

    actual fun error(message: String,tag: String) {
        Log.e("ERROR [${tag}",message)
    }

}