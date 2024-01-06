package app.domain.models.values

import app.domain.models.ResultModel
import app.domain.models.responses.MessageResponseModel

@JvmInline
value class PasswordValue private constructor(private val value: String) {
    operator fun invoke() = value

    companion object {
        operator fun invoke(value: String?): ResultModel<PasswordValue, MessageResponseModel> =
            if (value != null && isValid(value)) ResultModel.Success(PasswordValue(value))
            else ResultModel.Failure(MessageResponseModel(message = MessagesValues.INVALID_PASSWORD.message))

        private fun isValid(value: String): Boolean {
            val pattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{6,}\$".toRegex()

            return pattern.matches(value)
        }
    }
}
