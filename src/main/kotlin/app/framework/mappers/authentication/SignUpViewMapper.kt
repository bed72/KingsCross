package app.framework.mappers.authentication

import app.data.mappers.Mapper

import app.framework.views.authentication.SignUpOutView

import app.external.network.responses.authentication.SignUpResponse

class SignUpViewMapper : Mapper<SignUpResponse, SignUpOutView> {
    override fun invoke(map: SignUpResponse) =
        SignUpOutView(
            expireIn = map.expireIn,
            accessToken = map.accessToken,
            refreshToken = map.refreshToken,
            name = map.user.userMetadata.name,
            email = map.user.email,
        )
}