package app.application.usecases.user

import kotlinx.coroutines.withContext

import app.domain.entities.User
import app.domain.entities.types.CreateUserType

import app.domain.repositories.UserRepository

import app.domain.usecases.UseCase
import app.domain.usecases.user.UserCreateUseCase
import app.domain.usecases.corroutine.CoroutinesUseCase

class UserCreateUseCaseImpl(
    private val useCase: CoroutinesUseCase,
    private val repository: UserRepository
) : UserCreateUseCase, UseCase<User, CreateUserType>() {
    override suspend fun doWork(parameter: User) =
        withContext(useCase.io()) { repository.create(parameter) }
}
