package app.domain.models.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthenticationResponseModel(
    @SerialName("expires_in")
    val expireIn: Int,

    @SerialName("access_token")
    val accessToken: String,

    @SerialName("refresh_token")
    val refreshToken: String,

    @SerialName("user")
    val user: AuthenticationUserResponseModel,
)

@Serializable
data class AuthenticationUserResponseModel(
    @SerialName("email")
    val email: String,

    @SerialName("user_metadata")
    val userMetadata: AuthenticationMetadataResponseModel,
)

@Serializable
data class AuthenticationMetadataResponseModel(
    @SerialName("name")
    val name: String? = null,
)