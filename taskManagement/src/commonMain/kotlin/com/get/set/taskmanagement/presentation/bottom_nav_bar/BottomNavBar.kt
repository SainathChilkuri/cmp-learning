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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
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
import com.get.set.designsystem.util.DSAsset
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview

class AppBottomNavigationBar(bottomNavBarViewModel: BottomNavBarViewModel): BasePage<BottomNavBarViewModel>(bottomNavBarViewModel) {

    @Composable
    override fun Content(paddingValues: PaddingValues, viewModel: BottomNavBarViewModel) {
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
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home",
                        tint = AppColors.primaryColor,
                        modifier = Modifier.fillMaxHeight(),
                    )
                    Icon(
                        imageVector = Icons.Default.Book,
                        contentDescription = "Home",
                        modifier = Modifier.fillMaxHeight()
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    Icon(
                        imageVector = Icons.Default.Book,
                        contentDescription = "Home",
                        modifier = Modifier.fillMaxHeight()
                    )
                    Icon(
                        imageVector = Icons.Default.Book,
                        contentDescription = "Home",
                        modifier = Modifier.fillMaxHeight()
                    )
                }
            }

            FloatingActionButton(
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
                containerColor = Color.Transparent,
                contentColor = Color.Transparent,
                content = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = AppColors.white,
                        modifier = Modifier.fillMaxHeight()
                    )
                },
                onClick = {

                }
            )
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