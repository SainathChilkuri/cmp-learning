package org.demo.cmp.project.design_system

import AppColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import org.demo.cmp.project.utils.poppins

@Composable
fun AppText(value: String, textAlign: TextAlign?= null , size: Int = 14, fontWeight: FontWeight?= FontWeight.Medium,color: Color= AppColors.onyxBlack) {
    Text(
        value,
        textAlign = textAlign,
        fontFamily = poppins(),
        fontSize = size.sp,
        fontWeight = fontWeight,
        color = color
    )
}