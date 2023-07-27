package app.data.repositories.user

import app.data.datasources.local.user.LocalUserDatasource
import app.domain.parameters.authentication.SignUpParameter

interface UserRepository {
    suspend fun create(parameters: SignUpParameter)
}

class UserRepositoryImpl(
    private val datasource: LocalUserDatasource
) : UserRepository {
    override suspend fun create(parameters: SignUpParameter) {
        datasource.create(parameters)
    }
}