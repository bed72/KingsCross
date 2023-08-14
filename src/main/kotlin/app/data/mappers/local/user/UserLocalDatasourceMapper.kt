package app.data.mappers.local.user

import app.data.mappers.Mapper

import app.external.database.entities.UserEntity

import app.domain.parameters.authentication.SignUpParameter

class UserLocalDatasourceMapper : Mapper<SignUpParameter, UserEntity> {
    override fun invoke(map: SignUpParameter) = UserEntity {
        name = map.name.value
        email = map.email.value
        password = map.password.value
    }
}
