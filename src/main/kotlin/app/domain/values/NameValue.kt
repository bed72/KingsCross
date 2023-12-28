package app.domain.values

import app.domain.results.Result
import app.domain.entities.MessageOutEntity

@JvmInline
value class NameValue private constructor(private val value: String) {
    operator fun invoke() = value

    companion object {
        private const val MAX_LENGTH = 3
        operator fun invoke(value: String?): Result<NameValue, MessageOutEntity> =
            if (value != null && isValid(value)) Result.Success(NameValue(value))
            else Result.Failure(MessageOutEntity(MessagesValues.INVALID_NAME.message))

        private fun isValid(value: String): Boolean = value.length >= MAX_LENGTH
    }
}
