package app.data.mappers.authentication

import app.data.mappers.Mapper

import app.domain.parameters.authentication.SignUpParameter

import app.external.network.resquests.authentication.SignUpRequest
import app.external.network.resquests.authentication.SignUpDataRequest

class SignUpDatasourceMapper : Mapper<SignUpParameter, SignUpRequest> {
    override fun invoke(map: SignUpParameter) =
        SignUpRequest(
            email = map.email.value,
            password = map.password.value,
            data = SignUpDataRequest(name = map.name.value)
        )
}