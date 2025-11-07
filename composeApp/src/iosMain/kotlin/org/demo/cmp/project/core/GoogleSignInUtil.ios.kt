package org.demo.cmp.project.core

import com.get.set.firebasedatasource.core.FirebaseAuthWithGoogle

actual object GoogleSignInUtility {
    actual fun instance(): FirebaseAuthWithGoogle {
       return FirebaseAuthWithGoogle();
    }
}