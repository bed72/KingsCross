package app.factories

import arrow.core.left
import arrow.core.right

import app.domain.values.NameValue
import app.domain.values.EmailValue
import app.domain.values.PasswordValue

import app.domain.parameters.authentication.SignUpParameter

import app.external.network.responses.message.MessageResponse
import app.external.network.responses.authentication.SignUpResponse
import app.external.network.responses.authentication.SignUpUserResponse
import app.external.network.responses.authentication.SignUpUserMetadataResponse

class SignUpFactory {
    val validParams = SignUpParameter(
        NameValue("Gabriel Ramos"),
        EmailValue("email@email.com"),
        PasswordValue("P@ssw0rD"),
    )

    val invalidParams = SignUpParameter(
        NameValue(""),
        EmailValue(""),
        PasswordValue(""),
    )

    val failure get() = create(Mock.Failure)
    val success get() = create(Mock.Success)

    private fun create(mock: Mock) = when (mock) {
        Mock.Failure -> (400 to MessageResponse("Este e-mail já foi cadastrado.")).left()
        Mock.Success -> (
            200 to SignUpResponse(
                3600,
                "5CQcsREkB5xcqbY1L...",
                "5CQcsREkB5xcqbY1L...",
                SignUpUserResponse(
                    "bed@email.com",
                    SignUpUserMetadataResponse("Bed")
                )
            )
            ).right()
    }

    sealed class Mock {
        data object Success : Mock()
        data object Failure : Mock()
    }
}
