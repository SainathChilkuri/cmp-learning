package org.demo.cmp.project.presentation.screens.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.get.set.coremodule.BasePage
import org.demo.cmp.project.utils.SafeArea

class DashboardScreen(private val dashboardViewModel: DashboardViewModel): BasePage<DashboardViewModel>(viewModel = dashboardViewModel) {

    @Composable
    override fun Content(paddingValues: PaddingValues, viewModel: DashboardViewModel) {
       SafeArea {
           Box(
               contentAlignment = Alignment.Center
           ) {
               Column(
                   modifier = Modifier.fillMaxSize(),
                   verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.CenterHorizontally
               ) {
                   Text("Dashboard")
               }
           }

       }
    }
}