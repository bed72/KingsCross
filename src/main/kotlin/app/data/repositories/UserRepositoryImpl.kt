package app.data.repositories

import app.domain.entities.UserModel
import app.domain.entities.types.CreateUserType

import app.domain.repositories.UserRepository

import app.data.datasources.LocalUserDatasource

class UserRepositoryImpl(
    private val datasource: LocalUserDatasource
) : UserRepository {
    override suspend fun create(parameters: UserModel): CreateUserType = datasource.create(parameters)
}
