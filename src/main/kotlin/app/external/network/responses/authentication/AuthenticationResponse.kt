package app.external.network.responses.authentication

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthenticationResponse(
    @SerialName("expires_in")
    val expireIn: Int,

    @SerialName("access_token")
    val accessToken: String,

    @SerialName("refresh_token")
    val refreshToken: String,

    @SerialName("user")
    val user: AuthenticationUserResponse,
)

@Serializable
data class AuthenticationUserResponse(
    @SerialName("email")
    val email: String,

    @SerialName("user_metadata")
    val userMetadata: AuthenticationMetadataResponse,
)

@Serializable
data class AuthenticationMetadataResponse(
    @SerialName("name")
    val name: String,
)
