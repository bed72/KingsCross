package app.application.dtos

import app.domain.entities.UserIn
import app.domain.entities.UserOut

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    @SerialName("id")
    val id: String,

    @SerialName("name")
    val name: String,

    @SerialName("email")
    val email: String,

    @SerialName("password")
    val password: String,
) {
    companion object {
        fun toDto(model: UserOut) = UserDto(
            id = "",
            name = model.name,
            email = model.email,
            password = model.password
        )
    }
}

fun UserDto.toModel() = UserIn.validated(name, email, password)
