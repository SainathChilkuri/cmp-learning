package org.demo.cmp.project.design_system

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VerticalSpacer(value: Int) {
    Box(modifier = Modifier.height(value.dp))
}