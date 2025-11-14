package com.get.set.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.get.set.designsystem.util.AppColors
import com.get.set.designsystem.util.poppins

@Composable
fun AppTextField(value: String, label: String?=null, onValueChange: (String) -> Unit, trailingIcon: @Composable() (() -> Unit)? = null) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFF5F5F5), // light gray background
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 8.dp),
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            trailingIcon = trailingIcon,
            textStyle = TextStyle(
                fontFamily = poppins(),
                fontSize = 16.sp,
                fontWeight = FontWeight.W500
            ),
            placeholder = {
                AppText(
                    label ?: "",
                    color = AppColors.grey002,
                    size = 16,
                    fontWeight = FontWeight.W500
                )
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = AppColors.grey002,
                focusedLabelColor = AppColors.grey002,
                unfocusedTextColor = AppColors.grey002,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            singleLine = true,
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight()
        )
    }
}