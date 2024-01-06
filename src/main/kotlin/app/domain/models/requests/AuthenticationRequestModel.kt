package app.domain.models.requests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import app.domain.models.ResultModel
import app.domain.models.values.EmailValue
import app.domain.models.values.PasswordValue

@Serializable
class AuthenticationRequestModel private constructor(
    @SerialName("email")
    val email: String,

    @SerialName("password")
    val password: String
) {
    companion object {
        operator fun invoke(email: String, password: String): ResultModel<AuthenticationRequestModel, List<String>> {
            val messages = mutableListOf<String>()

            EmailValue(email).also {
                if (it is ResultModel.Failure && it.failure.message != null) messages.add(it.failure.message)
            }

            PasswordValue(password).also {
                if (it is ResultModel.Failure && it.failure.message != null) messages.add(it.failure.message)
            }

            return if (messages.isEmpty()) ResultModel.Success(AuthenticationRequestModel(email, password))
            else ResultModel.Failure(messages.toList())
        }
    }
}
