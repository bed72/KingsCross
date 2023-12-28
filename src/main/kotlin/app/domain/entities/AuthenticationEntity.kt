package app.domain.entities

import app.domain.results.Result
import app.domain.values.EmailValue
import app.domain.values.PasswordValue

data class AuthenticationOutEntity(
    val expireIn: Int,
    val name: String?,
    val email: String,
    val accessToken: String,
    val refreshToken: String
)

class AuthenticationInEntity private constructor(
    val email: String,
    val password: String
) {
    companion object {
        operator fun invoke(email: String, password: String): Result<AuthenticationInEntity, List<String>> {
            val messages = mutableListOf<String>()

            EmailValue(email).also {
                if (it is Result.Failure) messages.add(it.failure.message)
            }

            PasswordValue(password).also {
                if (it is Result.Failure) messages.add(it.failure.message)
            }

            return if (messages.isEmpty()) Result.Success(AuthenticationInEntity(email, password))
            else Result.Failure(messages.toList())
        }
    }
}
