package app.external.database.entities

import java.util.UUID
import java.time.LocalDateTime

import org.ktorm.schema.uuid
import org.ktorm.schema.Table
import org.ktorm.entity.Entity
import org.ktorm.schema.varchar
import org.ktorm.schema.datetime
import org.ktorm.support.postgresql.defaultValue

interface BaseEntity<E : Entity<E>> : Entity<E> {
    var id: UUID?
    var created: LocalDateTime?
    var updated: LocalDateTime?
    var deleted: LocalDateTime?
}

interface UserEntity : Entity<UserEntity> {
    companion object : Entity.Factory<UserEntity>()

    var id: UUID
    var name: String
    var email: String
    var created: LocalDateTime?
    var updated: LocalDateTime?
    var deleted: LocalDateTime?
}

object UsersEntity : Table<UserEntity>("users") {
    val id = uuid("id").primaryKey().bindTo(UserEntity::id)//.defaultValue()
    val name = varchar("name").bindTo(UserEntity::name)
    val email = varchar("email").bindTo(UserEntity::email)
//    val created = datetime("created").bindTo(UserEntity::created)
//    val updated = datetime("updated").bindTo(UserEntity::updated)
//    val deleted = datetime("deleted").bindTo(UserEntity::deleted)
}
