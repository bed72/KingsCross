package app.external.repositories

import app.external.clients.DatabaseClient

import app.domain.entities.types.CreateUserType

import app.data.adapters.UserAdapter
import app.data.datasources.LocalUserDatasource
import app.domain.entities.User

class LocalUserRepository(
    private val adapter: UserAdapter,
    private val client: DatabaseClient
) : LocalUserDatasource {
//    override suspend fun create(parameter: UserModel): CreateUserType =
//        try {
////            val id = client.invoke.insertAndGenerateKey(UsersEntity) {
////                set(it.name, parameter.name.value)
////                set(it.email, parameter.email.value)
////            }
//
//            client.of.sequenceOf(Users).run {
//                add(adapter.toEntity(parameter))

//                val data = filter { it.email eq  parameter.email.value }.last()

//                adapter.toModel(data).right()

    //            }
//        } catch (_: Exception) {
//            MessageModel("Ops, um erro aconteceu ao tentar salvar o usuário!").left()
//        }
    override suspend fun create(parameter: User): CreateUserType {
        TODO("Not yet implemented")
    }

}



