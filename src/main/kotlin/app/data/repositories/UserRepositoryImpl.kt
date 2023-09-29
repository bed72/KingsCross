package app.data.repositories

import app.domain.core.models.UserInModel
import app.domain.core.types.UserType
import app.domain.repositories.UserRepository
import app.domain.datasources.LocalUserDatasource

class UserRepositoryImpl(
    private val datasource: LocalUserDatasource
) : UserRepository {
    override suspend fun create(parameters: UserInModel): UserType = datasource.create(parameters)
}
