package org.demo.cmp.project.core

import org.demo.cmp.project.domain.models.GoogleAccountData

expect object GoogleSignInUtil {
    suspend fun signIn() : GoogleAccountData?
    suspend fun signOut()
}