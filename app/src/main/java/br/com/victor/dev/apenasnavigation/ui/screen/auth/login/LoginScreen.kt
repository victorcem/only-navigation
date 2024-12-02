package br.com.victor.dev.apenasnavigation.ui.screen.auth.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onSingUpClick: () -> Unit,
    onForgotClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.clickable { onLoginClick() },
            text = "Login",
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.clickable { onSingUpClick() },
            text = "Sign Up",
            fontWeight = FontWeight.Medium
        )
        Text(
            modifier = Modifier.clickable { onForgotClick() },
            text = "Forgot Password",
            fontWeight = FontWeight.Medium
        )
    }
}