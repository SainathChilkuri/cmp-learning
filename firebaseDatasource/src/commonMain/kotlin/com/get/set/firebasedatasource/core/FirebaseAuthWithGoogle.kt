package com.get.set.firebasedatasource.core

import com.get.set.firebasedatasource.model.GoogleAccountData

expect class FirebaseAuthWithGoogle() {
    suspend fun signIn(): GoogleAccountData?
    suspend fun signOut()
}