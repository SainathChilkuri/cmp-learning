package org.demo.cmp.project.core

import org.demo.cmp.project.domain.models.GoogleAccountData

actual object GoogleSignInUtil {
    actual suspend fun signIn(): GoogleAccountData? {
        ///TODO: to be implemented
    }

    actual suspend fun signOut() {
        ///TODO: to be implemented
    }
}