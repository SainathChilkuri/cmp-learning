package com.get.set.designsystem.util

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SafeArea(content: @Composable (Modifier) -> Unit) {
    val modifier = Modifier.padding(
        WindowInsets.safeContent.asPaddingValues()// Android
        // On iOS, you can inject safeAreaInsets here
    )
    content(modifier)
}