package coopbank.co.ke.repository

import ApiService
import coopbank.co.ke.data.api.model.LoginRequest
import coopbank.co.ke.data.api.model.LoginResponse

class AuthRepository(private val apiService: ApiService) {

    suspend fun login(loginRequest: LoginRequest, param: (Any) -> Unit): Result<LoginResponse> {
        try {
            val response = apiService.login(loginRequest)
            if (response.isSuccessful) {
                return Result.success(response.body()!!)
            } else {
                return Result.failure(Exception(response.errorBody()?.string()))
            }
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}
