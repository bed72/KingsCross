package app.framework.views.authentication

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import app.domain.values.EmailValue
import app.domain.values.PasswordValue

import app.domain.parameters.authentication.SignInParameter

@Serializable
data class SignInInView(
    @SerialName("email")
    val email: String,

    @SerialName("password")
    val password: String,
)

fun SignInInView.toParameter() =
    SignInParameter(EmailValue(email), PasswordValue(password))
