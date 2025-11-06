package com.get.set.auth.core

import com.get.set.firebasedatasource.model.GoogleAccountData

expect object GoogleSignInUtility {
    suspend fun signIn() : GoogleAccountData?
    suspend fun signOut()
}