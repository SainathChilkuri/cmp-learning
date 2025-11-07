package org.demo.cmp.project

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.get.set.firebasedatasource.core.FirebaseInstance
import org.demo.cmp.project.di.Koin

class MainActivity : ComponentActivity() {

    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        appContext = this
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        FirebaseInstance.initialize(this)
        Koin.initKoin()
        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}