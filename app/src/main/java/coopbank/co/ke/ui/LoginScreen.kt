package coopbank.co.ke.ui

import LoginViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import coopbank.co.ke.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(viewModel: LoginViewModel) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            imageVector = ImageVector.vectorResource(R.drawable.logo),
            contentDescription = "Logo"
        )
//        logo here

        // Username field
        TextField(
            value = viewModel.userNameState.value,
            onValueChange = { viewModel.onUserNameChanged(it) },
            label = { Text("User name") },
            modifier = Modifier.fillMaxWidth()
        )

        // Password field
        TextField(
            value = viewModel.passwordState.value,
            onValueChange = { viewModel.onPasswordChanged(it) },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )

        // Login button
        Button(
            onClick = viewModel::onLoginClicked,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }

        // Loading indicator
        if (viewModel.loadingState.value) {
            CircularProgressIndicator()
        }

        // Error message
        if (viewModel.loginResultState.value is Result.failure) {
            val errorMessage = (viewModel.loginResultState.value as Any).exception.message
            Text(text = errorMessage ?: "Unknown error", color = Color.Red)
        }

    }
}
