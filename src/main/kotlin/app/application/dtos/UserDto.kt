package app.application.dtos

import app.domain.core.values.Name
import app.domain.core.values.Code
import app.domain.core.values.Email

import app.domain.core.models.UserModel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    @SerialName("id")
    val id: String? = null,

    @SerialName("name")
    val name: String,

    @SerialName("email")
    val email: String,
)

fun UserDto.toModel() = UserModel(Code(id ?: ""), Name(name), Email(email))
