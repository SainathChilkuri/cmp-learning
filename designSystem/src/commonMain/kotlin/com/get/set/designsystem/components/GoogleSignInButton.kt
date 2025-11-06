package com.get.set.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import demo_cmp_project.designsystem.generated.resources.Res
import demo_cmp_project.designsystem.generated.resources.amico
import demo_cmp_project.designsystem.generated.resources.google
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