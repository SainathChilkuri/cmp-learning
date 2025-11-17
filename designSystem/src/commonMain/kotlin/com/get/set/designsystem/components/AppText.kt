package com.get.set.designsystem.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.get.set.designsystem.util.AppColors
import com.get.set.designsystem.util.poppins

@Composable
fun AppText(value: String, textAlign: TextAlign?= null , size: Int = 14, fontWeight: FontWeight?= FontWeight.Medium,color: Color= AppColors.onyxBlack, modifier: Modifier = Modifier) {
    Text(
        value,
        textAlign = textAlign,
        fontFamily = poppins(),
        fontSize = size.sp,
        fontWeight = fontWeight,
        color = color,
        modifier = modifier
    )
}