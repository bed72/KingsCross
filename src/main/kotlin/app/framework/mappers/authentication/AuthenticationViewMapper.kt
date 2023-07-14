package app.framework.mappers.authentication

import app.data.mappers.Mapper

import app.framework.views.authentication.AuthenticationOutView

import app.external.network.responses.authentication.AuthenticationResponse

class AuthenticationViewMapper : Mapper<AuthenticationResponse, AuthenticationOutView> {
    override fun invoke(map: AuthenticationResponse) =
        AuthenticationOutView(
            expireIn = map.expireIn,
            accessToken = map.accessToken,
            refreshToken = map.refreshToken,
            name = map.user.userMetadata.name,
            email = map.user.email,
        )
}