package app.factories.authentication

import arrow.core.left
import arrow.core.right

import app.domain.parameters.authentication.SignUpParameter

import app.external.network.responses.message.MessageResponse
import app.external.network.responses.authentication.AuthenticationResponse
import app.external.network.responses.authentication.AuthenticationUserResponse
import app.external.network.responses.authentication.AuthenticationMetadataResponse

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
        Mock.Failure -> (
                400 to MessageResponse(
                        "Este e-mail já foi cadastrado.",
                        "",
                        ""
                    )
                ).left()
        Mock.Success -> (
            200 to AuthenticationResponse(
                3600,
                "5CQcsREkB5xcqbY1L...",
                "5CQcsREkB5xcqbY1L...",
                AuthenticationUserResponse(
                    "bed@email.com",
                    AuthenticationMetadataResponse("Bed")
                )
            )
            ).right()
    }

    sealed class Mock {
        data object Success : Mock()
        data object Failure : Mock()
    }
}
