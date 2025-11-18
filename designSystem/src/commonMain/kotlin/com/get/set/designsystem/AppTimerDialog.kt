package com.get.set.designsystem

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.DialogProperties
import com.get.set.designsystem.components.AppPrimaryButton


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTimerDialog(timerState: TimePickerState, onDissmiss: () -> Unit, onConfirm: (TimePickerState) -> Unit) {

    BasicAlertDialog(
        onDismissRequest = onDissmiss,
    ) {
        Column {
            TimePicker(timerState)
            AppPrimaryButton(onTap = {
                onConfirm(timerState)
            }, label = "Confirm")
        }

    }

}