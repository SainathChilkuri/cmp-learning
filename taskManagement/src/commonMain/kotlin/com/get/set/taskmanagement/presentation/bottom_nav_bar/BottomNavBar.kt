package com.get.set.taskmanagement.presentation.bottom_nav_bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Man
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.SupervisedUserCircle
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Man
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.get.set.coremodule.BasePage
import com.get.set.designsystem.util.AppColors
import com.get.set.taskmanagement.presentation.bottom_nav_bar.widget.BottomNavIcon

class AppBottomNavigationBar(bottomNavBarViewModel: BottomNavBarViewModel, val onTabChange: (Int) -> Unit): BasePage<BottomNavBarViewModel>(bottomNavBarViewModel) {

    @Composable
    override fun Content(paddingValues: PaddingValues, viewModel: BottomNavBarViewModel) {
        val tabPosition = viewModel.currentTabPositionValue.collectAsState()

        Box {
            Box(
                modifier = Modifier
                    .clip(BottomBarCutoutShape(cutoutRadius = 130F))
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.height(65.dp).fillMaxWidth()
                        .background(color = AppColors.ghostWhite)
                ) {
                    BottomNavIcon(
                        selectedIcon = Icons.Filled.Home,
                        unselectedIcon = Icons.Outlined.Home,
                        isSelected = tabPosition.value == 0,
                        onTap = {
                            viewModel.onTabChange(0);
                            onTabChange(0)
                        }
                    )
                    BottomNavIcon(
                        selectedIcon = Icons.Filled.CalendarMonth,
                        unselectedIcon = Icons.Outlined.CalendarMonth,
                        isSelected = tabPosition.value == 1,
                        onTap = {
                            viewModel.onTabChange(1);
                            onTabChange(1)
                        }
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    BottomNavIcon(
                        selectedIcon = Icons.Filled.Book,
                        unselectedIcon = Icons.Outlined.Book,
                        isSelected = tabPosition.value == 2,
                        onTap = {
                            viewModel.onTabChange(2);
                            onTabChange(2)
                        }
                    )
                    BottomNavIcon(
                        selectedIcon = Icons.Filled.Person,
                        unselectedIcon = Icons.Outlined.Person,
                        isSelected = tabPosition.value == 3,
                        onTap = {
                            viewModel.onTabChange(3);
                            onTabChange(3)
                        }
                    )
                }
            }

            Box(
                modifier = Modifier.align(alignment = Alignment.BottomCenter).size(70.dp).offset(y = (-30).dp).background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            AppColors.blueCoala, // Blue
                            AppColors.pearlAqua
                        ),
                        start = Offset.Zero,             // top-left
                        end = Offset.Infinite
                    ),
                    shape = CircleShape,
                ),
            ) {
                Image(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    colorFilter = ColorFilter.tint(color = Color.White),
                    modifier = Modifier.fillMaxHeight().align(alignment = Alignment.Center)
                )
            }
        }
    }
}

class BottomBarCutoutShape(
    private val cutoutRadius: Float = 40f,
    private val cutoutVerticalOffset: Float = 0f // tweak if you want deeper cut
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            // Start from bottom-left
            moveTo(0f, 0f)
            lineTo(0f, size.height)
            lineTo(size.width, size.height)
            lineTo(size.width, 0f)

            // Calculate center of the bar
            val centerX = size.width / 2f

            // Move to right edge of the cutout
            lineTo(centerX + cutoutRadius, 0f)

            // Draw the semi-circle arc upwards (notch)
            arcTo(
                rect = Rect(
                    offset = Offset(centerX - cutoutRadius, -cutoutRadius + cutoutVerticalOffset),
                    size = Size(cutoutRadius * 2, cutoutRadius * 2)
                ),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 180f,
                forceMoveTo = false
            )

            // Continue to left edge of the cutout
            lineTo(centerX - cutoutRadius, 0f)
            close()
        }

        return Outline.Generic(path)
    }
}