package app.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

import app.domain.usecases.UseCase
import app.domain.core.models.UserModel
import app.domain.core.types.CreateUserType

import app.domain.repositories.UserRepository

import app.domain.usecases.corroutine.CoroutinesUseCase

interface UserCreateUseCase {
    operator fun invoke(parameter: UserModel): Flow<CreateUserType>
}

class UserCreateUseCaseImpl(
    private val useCase: CoroutinesUseCase,
    private val repository: UserRepository
) : UserCreateUseCase, UseCase<UserModel, CreateUserType>() {
    override suspend fun doWork(parameter: UserModel) =
        withContext(useCase.io()) { repository.create(parameter) }
}
