package app.data.dtos.requests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import app.domain.models.requests.AuthenticationRequestModel

@Serializable
data class AuthenticationRequestDto(
    @SerialName("email")
    val email: String,

    @SerialName("password")
    val password: String
)

fun AuthenticationRequestDto.toModel() = AuthenticationRequestModel(
    email = email,
    password = password
)
