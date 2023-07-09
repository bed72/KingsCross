package app.data.repositories.authentication

import app.domain.alias.SignUpType
import app.domain.parameters.authentication.SignUpParameter

import app.data.datasources.authentication.SignUpDatasource

interface SignUpRepository {
    suspend operator fun invoke(parameters: SignUpParameter): SignUpType
}

class SignUpRepositoryImpl(
    private val datasource: SignUpDatasource,
) : SignUpRepository {
    override suspend fun invoke(parameters: SignUpParameter): SignUpType = datasource(parameters)
}
