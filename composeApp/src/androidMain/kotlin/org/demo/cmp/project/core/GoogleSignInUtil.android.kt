package org.demo.cmp.project.core

import com.get.set.firebasedatasource.core.FirebaseAuthWithGoogle
import org.demo.cmp.project.MainActivity.Companion.appContext

actual object GoogleSignInUtility {
    actual fun instance(): FirebaseAuthWithGoogle {
        val firebaseAuthWithGoogle: FirebaseAuthWithGoogle = FirebaseAuthWithGoogle();
        firebaseAuthWithGoogle.setContext(appContext);
       return  firebaseAuthWithGoogle;
    }
}