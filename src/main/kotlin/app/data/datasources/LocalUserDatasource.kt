package app.data.datasources

import arrow.core.left
import arrow.core.right

import org.ktorm.dsl.eq
import org.ktorm.entity.add
import org.ktorm.entity.first
import org.ktorm.entity.filter
import org.ktorm.entity.sequenceOf

import app.data.adapters.UserAdapter

import app.domain.core.models.UserModel
import app.domain.core.models.MessageModel
import app.domain.core.types.CreateUserType

import app.domain.datasources.LocalUserDatasource

import app.external.database.entities.UsersEntity
import app.external.database.clients.DatabaseClient

class LocalUserDatasourceImpl(
    private val adapter: UserAdapter,
    private val client: DatabaseClient
) : LocalUserDatasource {
    override suspend fun create(parameter: UserModel): CreateUserType =
        try {
            client.invoke.sequenceOf(UsersEntity).run {
                add(adapter.toEntity(parameter))

                val data = filter { it.email eq  parameter.email.value }.first()

                adapter.toModel(data).right()

            }
        } catch (_: Exception) {
            MessageModel("Ops, um erro aconteceu ao tentar salvar o usuário!").left()
        }
}
