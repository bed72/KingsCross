package app.external.entities

import org.ktorm.schema.uuid
import org.ktorm.schema.Table
import org.ktorm.entity.Entity
import org.ktorm.schema.varchar
import org.ktorm.schema.datetime

object Users : Table<UserEntity>("users", ) {
    val id = uuid("id").primaryKey().bindTo(UserEntity::id)
    val name = varchar("name").bindTo(UserEntity::name)
    val email = varchar("email").bindTo(UserEntity::email)
    val created = datetime("created").bindTo(UserEntity::created)
    val updated = datetime("updated").bindTo(UserEntity::updated)
    val deleted = datetime("deleted").bindTo(UserEntity::deleted)
}

sealed interface UserEntity : BaseEntity<UserEntity> {
    companion object : Entity.Factory<UserEntity>()

    var name: String
    var email: String
}