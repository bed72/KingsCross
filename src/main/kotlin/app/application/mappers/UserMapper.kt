package app.application.mappers

import app.application.dtos.UserDto

import app.domain.core.models.UserModel

class UserMapper : Mapper<UserModel, UserDto> {
    override fun invoke(model: UserModel) = UserDto(model.id.value, model.name.value, model.email.value)
}