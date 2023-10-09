package app.domain.entities.values

import arrow.core.Nel
import arrow.core.right
import arrow.core.Either
import arrow.core.leftNel

import app.domain.entities.Message

@JvmInline
value class Name private constructor(val value: String) {
    operator fun invoke() = value

    companion object {
        operator fun invoke(value: String?): Either<Nel<Message>, Name> =
            when {
                value == null -> Message("O nome não pode ser nulo.").leftNel()
                value.length <= 2 -> Message("O nome precisa conter mais que 3 caracteres.").leftNel()
                value.length >= 10  -> Message("O nome precisa conter mamenos que 10 caracteres.").leftNel()
                else -> Name(value).right()
            }
    }
}
