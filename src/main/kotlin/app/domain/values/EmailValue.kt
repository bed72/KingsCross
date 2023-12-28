package app.domain.values

import app.domain.results.Result
import app.domain.entities.MessageOutEntity

@JvmInline
value class EmailValue private constructor(private val value: String) {
    operator fun invoke() = value

    companion object {
        operator fun invoke(value: String?): Result<EmailValue, MessageOutEntity> =
            if (value != null && isValid(value)) Result.Success(EmailValue(value))
            else Result.Failure(MessageOutEntity(MessagesValues.INVALID_EMAIL.message))

        private fun isValid(value: String): Boolean {
            val pattern = "^[a-zA-Z\\d+_.-]+@[a-zA-Z\\d.-]+\\.[a-zA-z]{2,3}\$".toRegex()

            return pattern.matches(value)
        }
    }
}