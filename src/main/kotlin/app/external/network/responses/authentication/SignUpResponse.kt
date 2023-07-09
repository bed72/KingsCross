package app.external.network.responses.authentication

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignUpResponse(
    @SerialName("expires_in")
    val expireIn: Int,

    @SerialName("access_token")
    val accessToken: String,

    @SerialName("refresh_token")
    val refreshToken: String,

    @SerialName("user")
    val user: SignUpUserResponse,
)

@Serializable
data class SignUpUserResponse(
    @SerialName("email")
    val email: String,

    @SerialName("user_metadata")
    val userMetadata: SignUpUserMetadataResponse,
)

@Serializable
data class SignUpUserMetadataResponse(
    @SerialName("name")
    val name: String,
)
