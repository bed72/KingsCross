package app.domain.usecases.user

import kotlinx.coroutines.flow.Flow

import app.domain.entities.UserIn
import app.domain.entities.UserType

interface UserCreateUseCase {
    operator fun invoke(parameter: UserIn): Flow<UserType>
}
