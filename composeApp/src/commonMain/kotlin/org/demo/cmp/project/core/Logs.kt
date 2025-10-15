package org.demo.cmp.project.core

expect object AppLogs {
     fun info(message: String)
     fun warn(message: String)
     fun error(message: String)
}