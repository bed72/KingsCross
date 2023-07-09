package app.framework.views.authentication

import app.domain.values.EmailValue
import app.domain.values.NameValue
import app.domain.values.PasswordValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import app.domain.parameters.authentication.SignUpParameter

@Serializable
data class SignUpInView(
    @SerialName("name")
    val name: String,

    @SerialName("email")
    val email: String,

    @SerialName("password")
    val password: String,
)

fun SignUpInView.toParameter() =
    SignUpParameter(NameValue(name), EmailValue(email), PasswordValue(password))

@Serializable
data class SignUpOutView(
    @SerialName("expires_in")
    val expireIn: Int,

    @SerialName("access_token")
    val accessToken: String,

    @SerialName("refresh_token")
    val refreshToken: String,

    @SerialName("name")
    val name: String,

    @SerialName("email")
    val email: String,
)