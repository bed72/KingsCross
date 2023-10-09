package app.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

import app.domain.entities.User

import app.domain.entities.types.CreateUserType

import app.domain.repositories.UserRepository

import app.domain.usecases.UseCase
import app.domain.usecases.corroutine.CoroutinesUseCase

interface UserCreateUseCase {
    operator fun invoke(parameter: User): Flow<CreateUserType>
}

class UserCreateUseCaseImpl(
    private val useCase: CoroutinesUseCase,
    private val repository: UserRepository
) : UserCreateUseCase, UseCase<User, CreateUserType>() {
    override suspend fun doWork(parameter: User) =
        withContext(useCase.io()) { repository.create(parameter) }
}
