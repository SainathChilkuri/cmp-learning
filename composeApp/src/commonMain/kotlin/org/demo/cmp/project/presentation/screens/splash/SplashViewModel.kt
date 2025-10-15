package org.demo.cmp.project.presentation.screens.splash

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.demo.cmp.project.core.BaseViewModel

class SplashViewModel : BaseViewModel() {

    private val _navigateToLogin = MutableStateFlow(false);
    val navigateToLogin: StateFlow<Boolean> = _navigateToLogin;

    init {
        viewModelScope.launch {
            delay(3000);
            _navigateToLogin.value = true;
        }
    }
}