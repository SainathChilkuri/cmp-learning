package org.demo.cmp.project.core

import com.get.set.firebasedatasource.core.signInOnIos
import com.get.set.firebasedatasource.core.signOutOnIos
import com.get.set.firebasedatasource.model.GoogleAccountData

actual object GoogleSignInUtil {
    actual suspend fun signIn(): GoogleAccountData? {
       return signInOnIos()
    }

    actual suspend fun signOut() {
        return signOutOnIos()
    }

}