package app.data.adapters

import java.time.LocalDateTime

import app.domain.core.models.UserModel
import app.external.entities.UserEntity

class UserAdapter : Adapter<UserEntity, UserModel> {
    override fun toEntity(model: UserModel) = UserEntity {
        name = model.name.value
        email = model.email.value
        created = LocalDateTime.now()
    }

    override fun toModel(entity: UserEntity) = UserModel.invoke(
        id = entity.id.toString(),
        name = entity.name,
        email = entity.email
    )
}
