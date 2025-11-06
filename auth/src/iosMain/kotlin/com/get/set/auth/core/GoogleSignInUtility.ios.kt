package com.get.set.auth.core

import androidx.compose.ui.platform.PlatformContext
import com.get.set.auth.domain.models.GoogleAccountData

actual object GoogleSignInUtility {
    actual suspend fun signIn(): GoogleAccountData? {
        TODO("Not yet implemented")

    }

    actual suspend fun signOut() {
    }
}