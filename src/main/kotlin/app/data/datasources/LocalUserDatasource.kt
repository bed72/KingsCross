package app.data.datasources

import app.domain.core.models.UserModel
import app.domain.core.types.CreateUserType

interface LocalUserDatasource {
    suspend fun create(parameter: UserModel): CreateUserType
}
