package com.get.set.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.get.set.designsystem.util.AppColors

@Composable
fun NameInitialWidget(initials: String) {
    Box(
        modifier = Modifier.height(150.dp).width(150.dp).background(
            color = AppColors.primaryColor,
            shape = CircleShape,
        ),
        contentAlignment = Alignment.Center
    ) {
        AppText(initials.uppercase(), size = 22, fontWeight = FontWeight.Bold, color = AppColors.white)
    }
}
