package app.domain.entities.values

import arrow.core.Nel
import arrow.core.right
import arrow.core.Either
import arrow.core.leftNel

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import app.domain.entities.Message

@JvmInline
value class Date private constructor(val value: LocalDateTime) {
    operator fun invoke() = value

    val toDate: String get() = value.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))

    companion object {
        operator fun invoke(value: LocalDateTime?): Either<Nel<Message>, Date> =
            when {
                value == null -> Message("O e-mail não pode ser nulo.").leftNel()
                value.isBefore(LocalDateTime.now().withHour(23).withMinute(59)) ->
                    Message("A data precisa ser após o dia de hoje.").leftNel()
                else -> Date(value).right()
            }
    }
}

