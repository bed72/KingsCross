package app.domain.entities

import arrow.core.EitherNel

import app.domain.entities.values.Email
import app.domain.entities.validations.validate
import app.domain.entities.values.Name
import app.domain.entities.values.Password

data class User private constructor(
    val name: Name,
    val email: Email,
    val password: Password
) {
    companion object {
        fun validated(name: String, email: String, password: String): EitherNel<Message, User> =
            validate(Name(name), Email(email), Password(password)) { validName, validEmail, validPassword ->
                User(validName, validEmail, validPassword)
            }
    }
}