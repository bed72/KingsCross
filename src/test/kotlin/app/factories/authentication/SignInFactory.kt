package app.factories.authentication

import arrow.core.left
import arrow.core.right

import app.domain.parameters.authentication.SignInParameter

import app.external.network.responses.message.MessageResponse
import app.external.network.responses.authentication.AuthenticationResponse
import app.external.network.responses.authentication.AuthenticationUserResponse
import app.external.network.responses.authentication.AuthenticationMetadataResponse

class SignInFactory {
    val validParams = SignInParameter(
        EmailValue("email@email.com"),
        PasswordValue("P@ssw0rD"),
    )

    val invalidParams = SignInParameter(
        EmailValue(""),
        PasswordValue(""),
    )

    val failure get() = create(Mock.Failure)
    val success get() = create(Mock.Success)

    private fun create(mock: Mock) = when (mock) {
        Mock.Failure -> (
                400 to MessageResponse(
                        "Credenciais inválidas.",
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
