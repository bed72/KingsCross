package app.domain.entities.values

import arrow.core.Nel
import arrow.core.right
import arrow.core.Either
import arrow.core.leftNel

import app.domain.entities.Message

@JvmInline
value class Password private constructor(val value: String) {
    operator fun invoke() = value

    companion object {
        operator fun invoke(value: String?): Either<Nel<Message>, Password> =
            when {
                value == null -> Message("A senha não pode ser nula.").leftNel()
                value.length <= 4 -> Message("A senha precisa conter mais que 4 caracteres.").leftNel()
                value.length >= 16  -> Message("A senha precisa conter mamenos que 16 caracteres.").leftNel()
                isValid(value) -> Password(value).right()
                else -> Message("Preencha uma senha válida.").leftNel()
            }

        private fun isValid(value: String): Boolean {
            val regex = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+")

            return regex.matches(value)
        }
    }
}
