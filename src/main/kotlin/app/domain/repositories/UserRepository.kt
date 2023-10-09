package app.domain.repositories

import app.domain.entities.UserIn
import app.domain.entities.UserType

interface UserRepository {
    suspend fun create(parameter: UserIn): UserType
}
