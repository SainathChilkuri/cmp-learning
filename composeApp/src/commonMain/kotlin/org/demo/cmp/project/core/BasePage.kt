package org.demo.cmp.project.core

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

abstract class BasePage<V : BaseViewModel>(val viewModel: V ) {

    @Composable
    fun Draw() {
         Scaffold (
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