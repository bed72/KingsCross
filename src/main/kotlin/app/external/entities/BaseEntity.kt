package app.external.entities

import java.util.UUID
import java.time.LocalDateTime

import org.ktorm.entity.Entity
import org.ktorm.schema.Table

interface BaseEntity<E : Entity<E>>: Entity<E> {
    var id: UUID?
    var created: LocalDateTime?
    var updated: LocalDateTime?
    var deleted: LocalDateTime?
}
