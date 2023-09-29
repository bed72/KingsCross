package app.domain.core.models

import app.domain.core.values.Name
import app.domain.core.values.Email

data class UserOutModel(
    val id: Int,
    val name: String,
    val email: String
)

data class UserInModel(
    val name: Name = Name(""),
    val email: Email = Email("")
) : Model {
    override fun isValid(): MutableSet<String?> =
        mutableSetOf(name.message, email.message).apply { removeIf { it == null } }
}
