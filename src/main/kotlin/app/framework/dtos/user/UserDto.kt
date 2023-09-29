package app.framework.dtos.user

import app.domain.core.values.Name
import app.domain.core.values.Email

import app.domain.core.models.UserInModel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserInDto(
    @SerialName("name")
    val name: String,

    @SerialName("email")
    val email: String,
)

fun UserInDto.toModel() = UserInModel(Name(name), Email(email))

@Serializable
data class UserOutDto(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("email")
    val email: String,
)