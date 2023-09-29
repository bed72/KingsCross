package app.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

import app.domain.usecases.UseCase
import app.domain.core.types.UserType
import app.domain.core.models.UserInModel

import app.domain.repositories.UserRepository

import app.domain.usecases.corroutine.CoroutinesUseCase

interface UserCreateUseCase {
    operator fun invoke(parameter: UserInModel): Flow<UserType>
}

class UserCreateUseCaseImpl(
    private val useCase: CoroutinesUseCase,
    private val repository: UserRepository
) : UserCreateUseCase, UseCase<UserInModel, UserType>() {
    override suspend fun doWork(parameter: UserInModel) =
        withContext(useCase.io()) { repository.create(parameter) }
}
