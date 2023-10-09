package app.application.dtos

import app.domain.entities.User

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
        fun toDto(model: User) = UserDto(
            id = "",
            name = model.name(),
            email = model.email(),
            password = model.password()
        )
    }
}

fun UserDto.toModel() = User.validated(name, email, password)
