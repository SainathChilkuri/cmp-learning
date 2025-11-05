package org.demo.cmp.project.data

import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import org.demo.cmp.project.MainActivity.Companion.appContext
import org.demo.cmp.project.core.AppLogs
import org.demo.cmp.project.domain.models.GoogleAccountData

actual object GoogleSignInUtil {
    actual suspend fun signIn(): GoogleAccountData? {
        return  withContext(Dispatchers.IO){
            try{
                // Instantiate a Google sign-in request
                val googleIdOption : GetGoogleIdOption = GetGoogleIdOption.Builder()
                    .setFilterByAuthorizedAccounts(false)
                    .setAutoSelectEnabled(true)
                    .setServerClientId("533057273649-k96qtl36v4ktrgnf259f6ni7iogqtsh0.apps.googleusercontent.com")
                    .build()

                AppLogs.info(googleIdOption.serverClientId, tag = "Google Sign In")

                // Create the Credential Manager request
                val request = GetCredentialRequest.Builder().addCredentialOption(googleIdOption).build()
                val credentialManager = CredentialManager.create(context = appContext)
                val credentialResponse = credentialManager.getCredential(appContext,request).credential
                val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credentialResponse.data)
                AppLogs.info("$${credentialResponse.data}", tag = "Google Sign In")

                val firebaseCredential = GoogleAuthProvider.getCredential(googleIdTokenCredential.idToken, null)
                val authResult = FirebaseAuth.getInstance().signInWithCredential(firebaseCredential).await()
                AppLogs.info("${authResult.user?.email}",tag = "Google Sign In")
                return@withContext GoogleAccountData(
                    email = authResult.user?.email,
                    displayName = authResult.user?.displayName,
                    username = authResult?.additionalUserInfo?.username
                );

            } catch (e: Exception) {
                AppLogs.error("${e.message}",tag = "Google Sign In")
                return@withContext null;
            }
        }
    }

    actual suspend fun signOut() {
        CoroutineScope(Dispatchers.IO).launch {
            FirebaseAuth.getInstance().signOut()
        }
    }
}