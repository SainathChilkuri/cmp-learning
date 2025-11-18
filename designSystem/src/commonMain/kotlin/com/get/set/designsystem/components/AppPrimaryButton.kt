package com.get.set.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.get.set.designsystem.util.AppColors

@Composable
fun AppPrimaryButton(
    onTap: () -> Unit,
    label: String,
    labelSize: Int = 18,
    labelWeight: FontWeight? = FontWeight.W700,
    backgroundColor: Color = AppColors.primaryColor,
    labelColor: Color = AppColors.white,
    buttonStatus: AppPrimaryButtonStatus = AppPrimaryButtonStatus.ACTIVE,
) {
    Button(
        onClick = {
            if (buttonStatus == AppPrimaryButtonStatus.ACTIVE) {
                onTap()
            }
        },
        contentPadding = PaddingValues(vertical = 20.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = if (buttonStatus == AppPrimaryButtonStatus.ACTIVE || buttonStatus == AppPrimaryButtonStatus.LOADING) backgroundColor else AppColors.grey002,
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        if (buttonStatus == AppPrimaryButtonStatus.LOADING) {
            CircularProgressIndicator(color = AppColors.white)
        } else {
            AppText(label, size = labelSize, fontWeight = labelWeight, color = labelColor)

        }

    }
}

enum class AppPrimaryButtonStatus {
    ACTIVE, DISABLED, LOADING
}