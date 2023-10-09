package app.external.clients.database.daos

import java.util.UUID

import org.ktorm.schema.uuid
import org.ktorm.schema.Table
import org.ktorm.entity.Entity
import org.ktorm.schema.varchar

object Users : Table<UserDAO>("users") {
    val id = uuid("id").primaryKey().bindTo(UserDAO::id)
    val name = varchar("name").bindTo(UserDAO::name)
    val email = varchar("email").bindTo(UserDAO::email)
    val password = varchar("password").bindTo(UserDAO::email)
}

sealed interface UserDAO : Entity<UserDAO> {
    var id: UUID?

    var name: String
    var email: String
    var password: String
    companion object : Entity.Factory<UserDAO>()

}
