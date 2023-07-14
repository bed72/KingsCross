package app.data.mappers.authentication

import app.data.mappers.Mapper

import app.domain.parameters.authentication.SignInParameter

import app.external.network.resquests.authentication.SignInRequest

class SignInDatasourceMapper : Mapper<SignInParameter, SignInRequest> {
    override fun invoke(map: SignInParameter) =
        SignInRequest(
            email = map.email.value,
            password = map.password.value,
        )
}