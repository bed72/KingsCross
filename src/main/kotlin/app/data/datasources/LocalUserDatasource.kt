package app.data.datasources

import arrow.core.left
import arrow.core.right

import org.ktorm.entity.add
import org.ktorm.entity.sequenceOf

import app.data.adapters.UserAdapter

import app.domain.core.types.UserType
import app.domain.core.models.UserInModel
import app.domain.core.models.MessageModel
import app.domain.core.models.UserOutModel

import app.domain.datasources.LocalUserDatasource

import app.external.database.entities.UsersEntity
import app.external.database.clients.DatabaseClient

class LocalUserDatasourceImpl(
    private val adapter: UserAdapter,
    private val client: DatabaseClient
) : LocalUserDatasource {
    override suspend fun create(parameter: UserInModel): UserType =
        try {
            val id = client.invoke.sequenceOf(UsersEntity).add(adapter(parameter))

            UserOutModel(id, parameter.name.value, parameter.email.value).right()
        } catch (_: Exception) {
            MessageModel("Ops, um erro aconteceu ao tentar salvar o usuário!").left()
        }
}
