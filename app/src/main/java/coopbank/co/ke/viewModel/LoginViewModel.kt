import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import coopbank.co.ke.data.api.model.LoginRequest
import coopbank.co.ke.data.api.model.LoginResponse
import coopbank.co.ke.repository.AuthRepository

class LoginViewModel(private val authRepository: AuthRepository) {

    private val _userNameState = mutableStateOf("")
    val userNameState: State<String> = _userNameState

    private val _passwordState = mutableStateOf("")
    val passwordState: State<String> = _passwordState

    private val _loadingState = mutableStateOf(false)
    val loadingState: State<Boolean> = _loadingState

    private val _loginResultState = mutableStateOf<Result<LoginResponse>?>(null)
    val loginResultState: State<Result<LoginResponse>?> = _loginResultState

    fun onUserNameChanged(userName: String) {
        _userNameState.value = userName
    }

    fun onPasswordChanged(password: String) {
        _passwordState.value = password
    }

     fun onLoginClicked() {
        _loadingState.value = true

        val loginRequest = LoginRequest(
            username = userNameState.value,
            password = passwordState.value
        )

        authRepository.login(loginRequest) { result ->
            _loadingState.value = false
            _loginResultState.value = result
        }
    }
}
