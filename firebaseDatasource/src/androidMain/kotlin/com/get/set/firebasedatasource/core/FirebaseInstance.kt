package com.get.set.firebasedatasource.core

import android.content.Context
import com.google.firebase.FirebaseApp

object FirebaseInstance {
    fun initialize(context: Context) {
        FirebaseApp.initializeApp(context)
    }
}