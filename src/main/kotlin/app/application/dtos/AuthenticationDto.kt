package app.application.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import app.domain.entities.AuthenticationInEntity
import app.domain.entities.AuthenticationOutEntity

@Serializable
data class AuthenticationInDto(
    @SerialName("email")
    val email: String,

    @SerialName("password")
    val password: String
)

fun AuthenticationInDto.toEntity() = AuthenticationInEntity(
    email = email,
    password = password
)

@Serializable
data class AuthenticationOutDto(
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
) {
    companion object {
        operator fun invoke(data: AuthenticationOutEntity) = AuthenticationOutDto(
            expireIn = data.expireIn,
            name = data.name,
            email = data.email,
            accessToken = data.accessToken,
            refreshToken = data.refreshToken
        )
    }
}
