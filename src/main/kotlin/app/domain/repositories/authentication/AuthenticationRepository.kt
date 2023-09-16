package app.domain.repositories.authentication

import app.domain.alias.SignUpType

import app.domain.parameters.authentication.SignUpParameter
import app.domain.parameters.authentication.SignInParameter

import app.domain.datasources.remote.authentication.RemoteAuthenticationDatasource

interface AuthenticationRepository {
    suspend fun signUp(parameter: SignUpParameter): SignUpType
    suspend fun signIn(parameter: SignInParameter): SignUpType
}

class AuthenticationRepositoryImpl(
    private val datasource: RemoteAuthenticationDatasource,
) : AuthenticationRepository {
    override suspend fun signUp(parameter: SignUpParameter): SignUpType = datasource.signUp(parameter)
    override suspend fun signIn(parameter: SignInParameter): SignUpType = datasource.signIn(parameter)
}
