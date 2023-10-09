package app.domain.entities

import arrow.core.EitherNel

import app.domain.entities.values.Email
import app.domain.entities.validations.validate
import app.domain.entities.values.Name
import app.domain.entities.values.Password
import arrow.core.Either

typealias UserType = Either<Message, UserOut>

data class UserOut(
    val id: String,
    val name: String,
    val email: String,
    val password: String
)

data class UserIn private constructor(
    val name: Name,
    val email: Email,
    val password: Password
) {
    companion object {
        fun validated(name: String, email: String, password: String): EitherNel<Message, UserIn> =
            validate(Name(name), Email(email), Password(password)) { validName, validEmail, validPassword ->
                UserIn(validName, validEmail, validPassword)
            }
    }
}