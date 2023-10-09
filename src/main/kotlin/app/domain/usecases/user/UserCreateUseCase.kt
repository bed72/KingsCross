package app.domain.usecases.user

import kotlinx.coroutines.flow.Flow

import app.domain.entities.User

import app.domain.entities.types.CreateUserType

interface UserCreateUseCase {
    operator fun invoke(parameter: User): Flow<CreateUserType>
}
