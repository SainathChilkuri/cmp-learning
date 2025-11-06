package com.get.set.coremodule

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.get.set.coremodule.util.AppColors
import org.jetbrains.compose.ui.tooling.preview.Preview

abstract class BasePage<V : BaseViewModel>(val viewModel: V ) {

    @Preview
    @Composable
    fun Draw() {
         Scaffold (
             containerColor = AppColors.white,
            topBar = { TopAppBarUnit() }
        ) { innerPadding ->
            Content(paddingValues = innerPadding, viewModel)
        }
    }

    @Composable
    abstract fun Content(paddingValues: PaddingValues, viewModel: V);

    @Composable
    open fun TopAppBarUnit() {

    }
}