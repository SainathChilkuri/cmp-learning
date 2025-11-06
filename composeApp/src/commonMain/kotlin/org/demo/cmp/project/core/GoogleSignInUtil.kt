package org.demo.cmp.project.core

import com.get.set.firebasedatasource.model.GoogleAccountData

expect class GoogleSignInUtil() {
    suspend fun signIn(): GoogleAccountData?

    suspend fun signOut()
}