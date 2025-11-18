package com.get.set.designsystem.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.get.set.designsystem.util.AppColors
import com.get.set.designsystem.util.poppins

@Composable
fun AppTextField(
    value: String,
    label: String? = null,
    onValueChange: (String) -> Unit,
    trailingIcon: @Composable() (() -> Unit)? = null,
    showLabelOnTop: Boolean = false,
    enabled: Boolean = true,
    validator: ((String) -> String?)? = null
) {


    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.height(intrinsicSize = IntrinsicSize.Min)
    ) {
        if (showLabelOnTop) AppText(
            label ?: "",
            size = 12,
            fontWeight = FontWeight.W500,
            color = AppColors.grey003,
            modifier = Modifier.padding(start = 3.dp)
        )
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
                enabled = enabled,
                textStyle = TextStyle(
                    fontFamily = poppins(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500
                ),
                isError = validator?.let {
                    it(value)
                } != null,
                shape = RoundedCornerShape(0),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences
                ),
                placeholder = {
                    AppText(
                        if (showLabelOnTop) "" else label ?: "",
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
                    errorPlaceholderColor = Color.Transparent,
                    errorContainerColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
                singleLine = true,
                modifier = Modifier
                    .weight(1F)
                    .height(60.dp)
            )
        }
        AnimatedVisibility(visible = (validator?.let { it(value) } ?: "").isNotEmpty()) {
            AppText(validator?.let { it(value) } ?: "",
                color = AppColors.error,
                size = 12,
                modifier = Modifier.padding(start = 4.dp))
        }
    }

}