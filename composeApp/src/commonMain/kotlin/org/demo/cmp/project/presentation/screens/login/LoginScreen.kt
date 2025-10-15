package org.demo.cmp.project.presentation.screens.login

import AppColors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import demo_cmp_project.composeapp.generated.resources.Res
import demo_cmp_project.composeapp.generated.resources.email
import demo_cmp_project.composeapp.generated.resources.enter_email
import demo_cmp_project.composeapp.generated.resources.enter_password
import demo_cmp_project.composeapp.generated.resources.forgot_password
import demo_cmp_project.composeapp.generated.resources.login
import demo_cmp_project.composeapp.generated.resources.password
import org.demo.cmp.project.core.BasePage
import org.jetbrains.compose.resources.stringResource

class LoginScreen (private val loginViewModel: LoginViewModel ): BasePage<LoginViewModel>(viewModel = loginViewModel ) {

    @Composable
    override fun Content(paddingValues: PaddingValues, viewModel: LoginViewModel) {
        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
       Box(
           modifier = Modifier.fillMaxSize().background(
               color = Color(0xFFB3E5FC)
           ).padding(horizontal = 30.dp),
           contentAlignment = Alignment.Center
       ) {

           Column(
               horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.Center
           ) {
              OutlinedTextField(
                  value = email.value,
                  label = { Text(stringResource(Res.string.email)) },
                  shape = RoundedCornerShape(12.dp),
                  textStyle = TextStyle(
                      color = AppColors.black,
                      fontSize = 16.sp
                  ),
                  colors = TextFieldDefaults.colors().copy(focusedPlaceholderColor = Color(0xFFFFFFFF),
                      focusedContainerColor = AppColors.white),
                  placeholder = { Text(stringResource(Res.string.enter_email)) },
                  onValueChange =  { text ->
                      email.value = text
                  },
                  keyboardOptions = KeyboardOptions(
                      keyboardType = KeyboardType.Email,
                      imeAction =  ImeAction.Done
                  ),
                  modifier = Modifier.fillMaxWidth()

              )
               Box(
                   modifier = Modifier.height(20.dp)
               )
               OutlinedTextField(
                   value = password.value,
                   label = { Text(stringResource(Res.string.password)) },
                   shape = RoundedCornerShape(12.dp),
                   textStyle = TextStyle(
                       color = AppColors.black,
                       fontSize = 16.sp
                   ),
                   visualTransformation = PasswordVisualTransformation(),
                   colors = TextFieldDefaults.colors().copy(focusedPlaceholderColor = Color(0xFFFFFFFF),
                       focusedContainerColor = AppColors.white),
                   placeholder = { Text(stringResource(Res.string.enter_password)) },
                   onValueChange =  { text ->
                       if (text.length <= 10) {   // 👈 Restrict to 10 characters
                           password.value = text
                       }
                   },
                   keyboardOptions = KeyboardOptions(
                       keyboardType = KeyboardType.Password,
                       imeAction =  ImeAction.Done
                   ),
                   modifier = Modifier.fillMaxWidth()

               )
               Box(
                   contentAlignment = Alignment.CenterEnd,
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(top = 10.dp)
               ) {
                   Text(stringResource(Res.string.forgot_password), modifier = Modifier.align(Alignment.CenterEnd) ,textDecoration = TextDecoration.Underline, color = AppColors.blue, fontSize = 12.sp, textAlign = TextAlign.Right)
               }
               Box(
                   modifier = Modifier.height(20.dp)
               )



                Button(
                    modifier = Modifier.size(width = 180.dp, height = 48.dp),
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors()
                ) {
                    Text(stringResource(Res.string.login))
                }
           }

       }
    }

}