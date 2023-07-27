package app.data.datasources.local.user

import org.ktorm.entity.add
import org.ktorm.entity.sequenceOf

import app.external.database.entities.UsersEntity

import app.external.database.clients.DatabaseClient

import app.domain.parameters.authentication.SignUpParameter

import app.data.mappers.local.user.UserLocalDatasourceMapper

interface LocalUserDatasource {
    suspend fun create(parameter: SignUpParameter)
}

class LocalUserDatasourceImpl(
    private val client: DatabaseClient,
    private val mapper: UserLocalDatasourceMapper
) : LocalUserDatasource {
    override suspend fun create(parameter: SignUpParameter) {
        client().sequenceOf(UsersEntity).add(mapper(parameter))
    }
}
