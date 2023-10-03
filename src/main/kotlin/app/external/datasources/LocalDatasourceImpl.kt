package app.external.datasources

import arrow.core.left
import arrow.core.right

import org.ktorm.dsl.eq
import org.ktorm.entity.add
import org.ktorm.entity.last
import org.ktorm.entity.filter
import org.ktorm.entity.sequenceOf

import app.external.entities.Users
import app.external.clients.DatabaseClient

import app.domain.core.models.UserModel
import app.domain.core.models.MessageModel
import app.domain.core.types.CreateUserType

import app.data.adapters.UserAdapter
import app.data.datasources.LocalUserDatasource

class LocalUserDatasourceImpl(
    private val adapter: UserAdapter,
    private val client: DatabaseClient
) : LocalUserDatasource {
    override suspend fun create(parameter: UserModel): CreateUserType =
        try {
//            val id = client.invoke.insertAndGenerateKey(UsersEntity) {
//                set(it.name, parameter.name.value)
//                set(it.email, parameter.email.value)
//            }

            client.of.sequenceOf(Users).run {
                add(adapter.toEntity(parameter))

                val data = filter { it.email eq  parameter.email.value }.last()

                adapter.toModel(data).right()

            }
        } catch (_: Exception) {
            MessageModel("Ops, um erro aconteceu ao tentar salvar o usuário!").left()
        }
}



