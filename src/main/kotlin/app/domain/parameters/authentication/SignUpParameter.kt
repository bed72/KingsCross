package app.domain.parameters.authentication

import arrow.core.Either

import arrow.core.raise.either
import arrow.core.raise.ensure
import arrow.core.raise.zipOrAccumulate

import app.domain.values.NameValue
import app.domain.values.EmailValue
import app.domain.values.PasswordValue

import app.domain.parameters.Parameters

data class SignUpParameter(
    val name: NameValue,
    val email: EmailValue,
    val password: PasswordValue,
) : Parameters<SignUpParameter>() {
    override fun isValid(): Either<List<String>, SignUpParameter> = either {
        val params = Triple(name(), email(), password())

        zipOrAccumulate(
            { before, after -> combine(before, after) },
            { ensure(params.first.isRight()) { prepare(params.first.leftOrNull()) } },
            { ensure(params.second.isRight()) { prepare(params.second.leftOrNull()) } },
            { ensure(params.third.isRight()) { prepare(params.third.leftOrNull()) } },
        ) { _, _, _ -> SignUpParameter(name, email, password) }
    }
}
