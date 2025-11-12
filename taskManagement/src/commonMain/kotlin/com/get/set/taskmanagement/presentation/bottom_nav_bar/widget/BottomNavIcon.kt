package com.get.set.taskmanagement.presentation.bottom_nav_bar.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.get.set.designsystem.util.AppColors

@Composable
fun BottomNavIcon(unselectedIcon: ImageVector, selectedIcon: ImageVector, isSelected: Boolean, onTap: () -> Unit, selectedColor: Color = AppColors.primaryColor, unselectedColor: Color = AppColors.primaryColorShade) {

    Icon(
        imageVector = if(isSelected) selectedIcon else unselectedIcon,
        contentDescription = "NavIcon",
        tint = if(isSelected) selectedColor else unselectedColor,
        modifier = Modifier.fillMaxHeight().clickable{
            onTap.invoke()
        }
    )
}