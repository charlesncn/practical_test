package coopbank.co.ke.ui

import LoginViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = viewModel.userNameState.value,
            onValueChange = viewModel.onUserNameChanged,
            label = { Text("UserName") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = viewModel.passwordState.value,
            onValueChange = viewModel.onPasswordChanged,
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = viewModel.onLoginClicked,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }

        if (viewModel.loadingState.value) {
            CircularProgressIndicator()
        }

        if (viewModel.loginResultState.value is Result.success) {
            val loginResponse = viewModel.loginResultState.value!!.getOrNull()!!
