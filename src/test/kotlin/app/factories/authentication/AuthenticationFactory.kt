package app.factories.authentication

import app.data.dtos.requests.AuthenticationRequestDto

import app.external.clients.evironment.EnvironmentClient
import app.external.clients.evironment.EnvironmentClientImpl

class AuthenticationFactory {
    private val env = EnvironmentClientImpl()

    val sigInValidParameter get() = AuthenticationRequestDto(
        env.get(EnvironmentClient.Keys.SUPABASE_TEST_EMAIL),
        env.get(EnvironmentClient.Keys.SUPABASE_TEST_PASSWORD)
    )
}