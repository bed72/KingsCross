package app.data.dtos.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import app.domain.models.responses.AuthenticationResponseModel

@Serializable
data class AuthenticationResponseDto(
    @SerialName("expire_in")
    val expireIn: Int,

    @SerialName("name")
    val name: String?,

    @SerialName("email")
    val email: String,

    @SerialName("access_token")
    val accessToken: String,

    @SerialName("refresh_token")
    val refreshToken: String
)

fun AuthenticationResponseModel.toDto() = AuthenticationResponseDto(
    email = user.email,
    expireIn = expireIn,
    accessToken = accessToken,
    refreshToken = refreshToken,
    name = user.userMetadata.name
)
