package coopbank.co.ke.data.api.model

data class LoginResponse(
    val token: String,
    val userId: String
    var firstName: String,
    var lastName: String,
    var email: String,
    var gender: String,
)