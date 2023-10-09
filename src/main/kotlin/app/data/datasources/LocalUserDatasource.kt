package app.data.datasources

import app.domain.entities.User
import app.domain.entities.types.CreateUserType

interface LocalUserDatasource {
    suspend fun create(parameter: User): CreateUserType
}
