package com.get.set.coremodule

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import demo_cmp_project.coremodule.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

abstract class BasePage<V : BaseViewModel>(val viewModel: V ) {

    protected var pagerState: PagerState ?= null

    protected lateinit var snackBarHostState: SnackbarHostState

    @Composable
    fun Draw() {
        snackBarHostState = remember { SnackbarHostState() }
        SafeArea {
            Scaffold(
                snackbarHost = { snackBarHostState },
                containerColor = Color.White,
                topBar = { TopAppBarUnit() },
                bottomBar = { BottomNavBar() }
            ) { innerPadding ->
                Content(paddingValues = innerPadding, viewModel)
            }
        }
    }

    @Composable
    abstract fun Content(paddingValues: PaddingValues, viewModel: V);



    @Composable
    open fun TopAppBarUnit() {

    }

    @Composable
    open fun BottomNavBar() {

    }
}