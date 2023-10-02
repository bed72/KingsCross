package app.domain.core.models

import app.domain.core.values.Code
import app.domain.core.values.Name
import app.domain.core.values.Email

data class UserModel(
    val id: Code = Code(""),
    val name: Name = Name(""),
    val email: Email = Email("")
) : Model {
    override fun hasMessage(): MutableSet<String?> =
        mutableSetOf(name.message, email.message).apply { removeIf { it == null } }

    companion object {
        operator fun invoke(id: String, name: String, email: String) = UserModel(Code(id), Name(name), Email(email))
    }
}
