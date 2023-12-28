package app.domain.repositories

import app.domain.entities.AuthenticationInEntity
import app.domain.entities.AuthenticationEntityType

interface AuthenticationRepository {
    suspend fun signIn(parameter: AuthenticationInEntity): AuthenticationEntityType
}
