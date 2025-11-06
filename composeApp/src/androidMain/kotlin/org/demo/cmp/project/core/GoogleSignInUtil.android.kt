package org.demo.cmp.project.core

import android.content.Context
import com.get.set.firebasedatasource.core.signInOnAndroid
import com.get.set.firebasedatasource.core.signOutOnAndroid
import com.get.set.firebasedatasource.model.GoogleAccountData
import org.demo.cmp.project.MainActivity.Companion.appContext

actual class GoogleSignInUtil(private val context: Context) {
    actual suspend fun signIn(): GoogleAccountData? {
        return signInOnAndroid(appContext);
    }

    actual suspend fun signOut() {
        return signOutOnAndroid();
    }
}