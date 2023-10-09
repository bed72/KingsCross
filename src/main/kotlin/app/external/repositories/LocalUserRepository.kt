package app.external.repositories

import arrow.core.left
import arrow.core.right

import org.ktorm.dsl.eq
import org.ktorm.entity.add
import org.ktorm.entity.last
import org.ktorm.entity.filter
import org.ktorm.entity.sequenceOf

import app.domain.entities.UserIn
import app.domain.entities.Message
import app.domain.entities.UserOut
import app.domain.entities.UserType

import app.domain.repositories.UserRepository

import app.external.clients.database.daos.Users
import app.external.clients.database.daos.UserDAO
import app.external.clients.database.DatabaseClient

class LocalUserRepository(
    private val client: DatabaseClient
) : UserRepository {
    override suspend fun create(parameter: UserIn): UserType =
        try {
            client.of.sequenceOf(Users).run {
                add(
                    UserDAO {
                        name = parameter.name()
                        email = parameter.email()
                        password = parameter.password()
                    }
                )

                val data = filter { it.email eq parameter.email() }.last()

                UserOut(
                    data.id.toString(),
                    data.name,
                    data.email,
                    data.password
                ).right()

            }
        } catch (_: Exception) {
            Message("Ops, um erro aconteceu ao tentar salvar o usuário!").left()
        }
}



