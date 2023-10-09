package app.external.entities

import java.util.UUID

import org.ktorm.schema.uuid
import org.ktorm.schema.Table
import org.ktorm.entity.Entity
import org.ktorm.schema.varchar

object Users : Table<UserEntity>("users", ) {
    val id = uuid("id").primaryKey().bindTo(UserEntity::id)
    val name = varchar("name").bindTo(UserEntity::name)
    val email = varchar("email").bindTo(UserEntity::email)
    val password = varchar("password").bindTo(UserEntity::email)
}

sealed interface UserEntity : Entity<UserEntity> {
    companion object : Entity.Factory<UserEntity>()

    var id: UUID?

    var name: String
    var email: String
    var password: String
}
