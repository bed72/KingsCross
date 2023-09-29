package app.framework.adapters.user

import app.data.adapters.Adapter

import app.framework.dtos.user.UserOutDto

import app.domain.core.models.UserOutModel

class UserViewAdapter : Adapter<UserOutModel, UserOutDto> {
    override fun invoke(data: UserOutModel) = UserOutDto(data.id, data.name, data.email)
}