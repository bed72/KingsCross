package app.domain.parameters.authentication

import arrow.core.Either

import arrow.core.raise.either
import arrow.core.raise.ensure
import arrow.core.raise.zipOrAccumulate

import app.domain.values.EmailValue
import app.domain.values.PasswordValue

import app.domain.parameters.Parameters

data class SignInParameter(
    val email: EmailValue,
    val password: PasswordValue
) : Parameters<SignInParameter>() {
    override fun isValid(): Either<List<String>, SignInParameter> = either {
        val params = email() to password()

        zipOrAccumulate(
            { before, after -> combine(before, after) },
            { ensure(params.first.isRight()) { prepare(params.first.leftOrNull()) } },
            { ensure(params.second.isRight()) { prepare(params.second.leftOrNull()) } },
        ) { _, _ -> SignInParameter(email, password) }
    }
}
