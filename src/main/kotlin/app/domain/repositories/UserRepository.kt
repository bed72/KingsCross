package app.domain.repositories

import app.domain.core.types.UserType
import app.domain.core.models.UserInModel

interface UserRepository {
    suspend fun create(parameters: UserInModel): UserType
}
