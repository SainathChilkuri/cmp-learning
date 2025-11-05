package org.demo.cmp.project.data

import androidx.compose.runtime.Composable
import org.demo.cmp.project.domain.models.GoogleAccountData

expect object GoogleSignInUtil {
    suspend fun signIn() : GoogleAccountData?
    suspend fun signOut()
}