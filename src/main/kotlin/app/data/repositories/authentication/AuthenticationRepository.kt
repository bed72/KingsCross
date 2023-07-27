package app.data.repositories.authentication

import app.domain.alias.SignUpType
import app.domain.parameters.authentication.SignUpParameter
import app.domain.parameters.authentication.SignInParameter

import app.data.datasources.remote.authentication.RemoteAuthenticationDatasource

interface AuthenticationRepository {
    suspend fun signUp(parameters: SignUpParameter): SignUpType
    suspend fun signIn(parameters: SignInParameter): SignUpType
}

class AuthenticationRepositoryImpl(
    private val datasource: RemoteAuthenticationDatasource,
) : AuthenticationRepository {
    override suspend fun signUp(parameters: SignUpParameter): SignUpType = datasource.signUp(parameters)
    override suspend fun signIn(parameters: SignInParameter): SignUpType = datasource.signIn(parameters)
}
