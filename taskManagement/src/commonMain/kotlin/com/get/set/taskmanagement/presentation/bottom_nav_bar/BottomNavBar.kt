package com.get.set.taskmanagement.presentation.bottom_nav_bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.get.set.coremodels.models.UserDataModel
import com.get.set.coremodule.BasePage
import com.get.set.coremodule.JsonSerializerUtil
import com.get.set.coremodule.navigations.NavigatorUtil
import com.get.set.coremodule.navigations.Screens
import com.get.set.designsystem.util.AppColors
import com.get.set.taskmanagement.presentation.bottom_nav_bar.widget.BottomNavIcon

class AppBottomNavigationBar(
    bottomNavBarViewModel: BottomNavBarViewModel,
    private val userDataModel: UserDataModel,
    private val selectedTab: Int = 0,
    val onTabChange: (Int) -> Unit,
) : BasePage<BottomNavBarViewModel>(bottomNavBarViewModel) {


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
                    BottomNavIcon(
                        selectedIcon = Icons.Filled.Home,
                        unselectedIcon = Icons.Outlined.Home,
                        isSelected = selectedTab == 0,
                        onTap = {
                            onTabChange(0)
                        }
                    )
                    BottomNavIcon(
                        selectedIcon = Icons.Filled.CalendarMonth,
                        unselectedIcon = Icons.Outlined.CalendarMonth,
                        isSelected = selectedTab == 1,
                        onTap = {
                            onTabChange(1)
                        }
                    )
                    Spacer(modifier = Modifier.width(40.dp))
                    BottomNavIcon(
                        selectedIcon = Icons.Filled.Book,
                        unselectedIcon = Icons.Outlined.Book,
                        isSelected = selectedTab == 2,
                        onTap = {
                            onTabChange(2)
                        }
                    )
                    BottomNavIcon(
                        selectedIcon = Icons.Filled.Person,
                        unselectedIcon = Icons.Outlined.Person,
                        isSelected = selectedTab == 3,
                        onTap = {
                            onTabChange(3)
                        }
                    )
                }
            }

            Box(
                modifier = Modifier.align(alignment = Alignment.BottomCenter).size(70.dp)
                    .offset(y = (-30).dp).background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            AppColors.blueCoala, // Blue
                            AppColors.pearlAqua
                        ),
                        start = Offset.Zero,             // top-left
                        end = Offset.Infinite
                    ),
                    shape = CircleShape,
                ).clickable {
                    NavigatorUtil.pushNamed(
                        Screens.Task(userDataModel)
                    );
                }
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