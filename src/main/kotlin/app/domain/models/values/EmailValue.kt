package app.domain.models.values

import app.domain.models.ResultModel
import app.domain.models.responses.MessageResponseModel

@JvmInline
value class EmailValue private constructor(private val value: String) {
    operator fun invoke() = value

    companion object {
        operator fun invoke(value: String?): ResultModel<EmailValue, MessageResponseModel> =
            if (value != null && isValid(value)) ResultModel.Success(EmailValue(value))
            else ResultModel.Failure(MessageResponseModel(message = MessagesValues.INVALID_EMAIL.message))

        private fun isValid(value: String): Boolean {
            val pattern = "^[a-zA-Z\\d+_.-]+@[a-zA-Z\\d.-]+\\.[a-zA-z]{2,3}\$".toRegex()

            return pattern.matches(value)
        }
    }
}
