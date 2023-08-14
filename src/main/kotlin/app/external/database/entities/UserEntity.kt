package app.external.database.entities

import org.ktorm.schema.long
import org.ktorm.schema.Table
import org.ktorm.entity.Entity
import org.ktorm.schema.varchar

interface UserEntity : Entity<UserEntity> {
    companion object : Entity.Factory<UserEntity>()

    val id: Long?
    var name: String
    var email: String
    var password: String
}

object UsersEntity : Table<UserEntity>("users") {
    val id = long("id").primaryKey().bindTo(UserEntity::id)
    val name = varchar("name").bindTo(UserEntity::name)
    val email = varchar("email").bindTo(UserEntity::email)
    val password = varchar("password").bindTo(UserEntity::password)
}
