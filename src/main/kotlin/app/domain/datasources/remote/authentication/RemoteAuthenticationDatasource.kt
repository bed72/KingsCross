package app.domain.datasources.remote.authentication

import app.domain.alias.SignUpType

import app.domain.parameters.authentication.SignUpParameter
import app.domain.parameters.authentication.SignInParameter

interface RemoteAuthenticationDatasource {
    suspend fun signUp(parameter: SignUpParameter): SignUpType
    suspend fun signIn(parameter: SignInParameter): SignUpType
}
