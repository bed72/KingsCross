package app.domain.models.values

import app.domain.models.ResultModel
import app.domain.models.responses.MessageResponseModel

@JvmInline
value class NameValue private constructor(private val value: String) {
    operator fun invoke() = value

    companion object {
        private const val MAX_LENGTH = 3
        operator fun invoke(value: String?): ResultModel<NameValue, MessageResponseModel> =
            if (value != null && isValid(value)) ResultModel.Success(NameValue(value))
            else ResultModel.Failure(MessageResponseModel(message = MessagesValues.INVALID_NAME.message))

        private fun isValid(value: String): Boolean = value.length >= MAX_LENGTH
    }
}
