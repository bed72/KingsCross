package app.domain.repositories

import app.domain.core.models.UserModel
import app.domain.core.types.CreateUserType

interface UserRepository {
    suspend fun create(parameters: UserModel): CreateUserType
}
