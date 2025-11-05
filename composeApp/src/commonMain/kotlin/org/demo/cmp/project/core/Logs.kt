package org.demo.cmp.project.core

expect object AppLogs {
     fun info(message: String,tag: String)
     fun warn(message: String,tag: String)
     fun error(message: String,tag: String)
}