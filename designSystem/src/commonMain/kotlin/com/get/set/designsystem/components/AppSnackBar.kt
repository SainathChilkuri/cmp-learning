package com.get.set.designsystem.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.get.set.designsystem.util.AppColors

@Composable
fun AppSnackBar(hostState: SnackbarHostState,) {
    Box (
        modifier = Modifier.padding(vertical = 30.dp)
    ){
        SnackbarHost(hostState = hostState) {
            Snackbar(
                snackbarData = it,
                containerColor = if ((it.visuals as AppSnackBarVisuals).appSnackBarType == AppSnackBarType.SUCCESS) AppColors.green else AppColors.error,
                contentColor = if ((it.visuals as AppSnackBarVisuals).appSnackBarType == AppSnackBarType.SUCCESS) AppColors.black else AppColors.white,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.padding(16.dp).align(alignment = Alignment.BottomCenter),
            )
        }
    }

}

enum class AppSnackBarType {
    SUCCESS,
    ERROR,
    INFO
}

data class AppSnackBarVisuals(
    override val actionLabel: String?,
    override val duration: SnackbarDuration,
    override val message: String,
    override val withDismissAction: Boolean,
    val appSnackBarType: AppSnackBarType
) : SnackbarVisuals {}