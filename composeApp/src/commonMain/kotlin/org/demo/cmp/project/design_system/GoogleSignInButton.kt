package org.demo.cmp.project.design_system

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import demo_cmp_project.composeapp.generated.resources.Res
import demo_cmp_project.composeapp.generated.resources.amico
import demo_cmp_project.composeapp.generated.resources.google
import demo_cmp_project.composeapp.generated.resources.google_sign_in_button
import org.demo.cmp.project.core.AppLogs
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun GoogleSignIn(onClick: () -> Unit) {
    Image(
        painter = painterResource(Res.drawable.google),
        contentDescription = "Google Sign In Image",
        modifier = Modifier.height(50.dp).padding(horizontal = 10.dp).clickable {
            onClick.invoke()
        }
    )
}