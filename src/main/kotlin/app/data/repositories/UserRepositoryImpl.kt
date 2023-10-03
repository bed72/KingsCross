package app.data.repositories

import app.domain.core.models.UserModel
import app.domain.core.types.CreateUserType

import app.domain.repositories.UserRepository

import app.data.datasources.LocalUserDatasource

class UserRepositoryImpl(
    private val datasource: LocalUserDatasource
) : UserRepository {
    override suspend fun create(parameters: UserModel): CreateUserType = datasource.create(parameters)
}
