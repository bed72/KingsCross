package app.data.adapters

import app.domain.core.models.UserInModel
import app.external.database.entities.UserEntity

class UserAdapter : Adapter<UserInModel, UserEntity> {
    override fun invoke(data: UserInModel) = UserEntity {
        name = data.name.value
        email = data.email.value
    }
}
