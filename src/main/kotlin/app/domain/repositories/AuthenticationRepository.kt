package app.domain.repositories

import app.domain.models.AuthenticationType
import app.domain.models.requests.AuthenticationRequestModel

interface AuthenticationRepository {
    suspend fun signIn(parameter: AuthenticationRequestModel): AuthenticationType
}
