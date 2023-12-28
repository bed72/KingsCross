package app.domain.values

import app.domain.results.Result
import app.domain.entities.MessageOutEntity

@JvmInline
value class PasswordValue private constructor(private val value: String) {
    operator fun invoke() = value

    companion object {
        operator fun invoke(value: String?): Result<PasswordValue, MessageOutEntity> =
            if (value != null && isValid(value)) Result.Success(PasswordValue(value))
            else Result.Failure(MessageOutEntity(MessagesValues.INVALID_PASSWORD.message))

        private fun isValid(value: String): Boolean {
            val pattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{6,}\$".toRegex()

            return pattern.matches(value)
        }
    }
}
