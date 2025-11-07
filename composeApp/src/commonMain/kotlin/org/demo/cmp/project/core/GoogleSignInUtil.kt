package org.demo.cmp.project.core

import com.get.set.firebasedatasource.core.FirebaseAuthWithGoogle

expect object GoogleSignInUtility {
     fun instance() : FirebaseAuthWithGoogle
}