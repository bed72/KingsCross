package app.domain.models

import app.domain.models.responses.MessageResponseModel
import app.domain.models.responses.AuthenticationResponseModel

sealed class ResultModel<out S, out F> {
    data class Success<out S>(val success: S) : ResultModel<S, Nothing>()
    data class Failure<out F>(val failure: F) : ResultModel<Nothing, F>()

    override fun toString() = when (this) {
        is Success<*> -> "Success: [$success]"
        is Failure<*> -> "Failure: [$failure]"
    }
}

typealias AuthenticationType = ResultModel<AuthenticationResponseModel, MessageResponseModel>
