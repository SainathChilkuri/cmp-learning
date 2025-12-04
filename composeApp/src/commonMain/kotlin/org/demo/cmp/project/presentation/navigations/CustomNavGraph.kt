package org.demo.cmp.project.presentation.navigations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.get.set.coremodule.navigations.Navigator
import com.get.set.coremodule.navigations.Screens
import com.get.set.auth.presentation.login.LoginScreen
import com.get.set.coremodels.models.UserDataModel
import com.get.set.coremodule.navigations.NavigatorUtil
import com.get.set.taskmanagement.presentation.bottom_bar_page_view.BottomBarPageView
import com.get.set.taskmanagement.presentation.task.TaskScreen
import org.demo.cmp.project.presentation.screens.splash.SplashScreen
import org.koin.core.Koin

@Composable
fun CustomNavGraph(navBackStack: SnapshotStateList<Screens>, koin: Koin) {
    CompositionLocalProvider(Navigator provides navBackStack) {
        NavigatorUtil.navHostController = Navigator.current;
        NavDisplay(
            backStack = navBackStack,
            entryDecorators = listOf(
                // Add the default decorators for managing scenes and saving state
                rememberSaveableStateHolderNavEntryDecorator(),
            ),
            entryProvider = entryProvider {
                entry<Screens.Splash> {
                    SplashScreen(splashViewModel = koin.get()).Draw()
                }

                entry<Screens.Login> {
                    LoginScreen(loginViewModel = koin.get()).Draw()
                }

                entry<Screens.Dashboard> { key ->
                    BottomBarPageView(
                        bottomBarPageViewModel = koin.get(),
                        userDataModel = key.userDataModel,
                        koin.get()
                    ).Draw()
                }

                entry<Screens.Task> { key ->
                    TaskScreen(taskViewModel = koin.get(), userDataModel = key.userDataModel).Draw()
                }
            }

        )
    }
}
