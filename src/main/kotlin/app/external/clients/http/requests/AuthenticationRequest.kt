package app.external.clients.http.requests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import app.domain.entities.AuthenticationInEntity

@Serializable
data class AuthenticationRequest(
    @SerialName("email")
    val email: String,

    @SerialName("password")
    val password: String
) {
    companion object {
        operator fun invoke(data: AuthenticationInEntity) =
            AuthenticationRequest(email = data.email, password = data.password)
    }
}
