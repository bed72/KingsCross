package app.domain.entities.values

import arrow.core.Nel
import arrow.core.right
import arrow.core.Either
import arrow.core.leftNel

import app.domain.entities.Message

@JvmInline
value class Email private constructor(val value: String) {
    operator fun invoke() = value
    companion object {
        operator fun invoke(value: String?): Either<Nel<Message>, Email> =
            when {
                value == null -> Message("O e-mail não pode ser nulo.").leftNel()
                isValid(value) -> Email(value).right()
                else -> Message("Preencha um e-mail válido.").leftNel()
            }

        private fun isValid(value: String): Boolean {
            val regex = Regex("^[A-Za-z0-9+_.-]+@(.+)$")

            return regex.matches(value)
        }
    }
}