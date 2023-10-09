package app.domain.repositories

import app.domain.entities.User
import app.domain.entities.types.CreateUserType

interface UserRepository {
    suspend fun create(parameters: User): CreateUserType
}
