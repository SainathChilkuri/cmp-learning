package com.get.set.coremodule

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SafeArea(content: @Composable (Modifier) -> Unit) {
    val modifier = Modifier.padding(
        WindowInsets.navigationBars
            .asPaddingValues()
    )

    Box (
        modifier = modifier
    ){
        content(modifier)
    }
}