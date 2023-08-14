package app.domain.repositories.user

import app.domain.parameters.authentication.SignUpParameter
import app.domain.datasources.local.user.LocalUserDatasource

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
