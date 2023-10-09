package app.application.usecases.user

import kotlinx.coroutines.withContext

import app.domain.entities.UserIn
import app.domain.entities.UserType

import app.domain.repositories.UserRepository

import app.domain.usecases.UseCase
import app.domain.usecases.user.UserCreateUseCase
import app.domain.usecases.corroutine.CoroutinesUseCase

class UserCreateUseCaseImpl(
    private val useCase: CoroutinesUseCase,
    private val repository: UserRepository
) : UserCreateUseCase, UseCase<UserIn, UserType>() {
    override suspend fun doWork(parameter: UserIn) =
        withContext(useCase.io()) { repository.create(parameter) }
}
