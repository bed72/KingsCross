package app.domain.datasources

import app.domain.core.types.UserType
import app.domain.core.models.UserInModel

interface LocalUserDatasource {
    suspend fun create(parameter: UserInModel): UserType
}
