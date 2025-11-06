package com.get.set.designsystem.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import demo_cmp_project.designsystem.generated.resources.Poppins_Bold
import demo_cmp_project.designsystem.generated.resources.Poppins_Italic
import demo_cmp_project.designsystem.generated.resources.Poppins_Medium
import demo_cmp_project.designsystem.generated.resources.Poppins_Regular
import demo_cmp_project.designsystem.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun poppins() = FontFamily(
    Font(Res.font.Poppins_Regular, weight = FontWeight.Normal),
    Font(Res.font.Poppins_Medium, weight = FontWeight.Medium),
    Font(Res.font.Poppins_Bold, weight = FontWeight.Bold),
    Font(Res.font.Poppins_Italic, weight = FontWeight.Normal, style = FontStyle.Italic),
)