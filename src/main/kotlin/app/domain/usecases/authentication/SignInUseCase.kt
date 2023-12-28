package app.domain.usecases.authentication

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

import app.domain.usecases.UseCase

import app.domain.entities.AuthenticationInEntity
import app.domain.entities.AuthenticationEntityType

import app.domain.usecases.corroutine.CoroutinesUseCase

import app.domain.repositories.AuthenticationRepository

interface SignInUseCase {
    operator fun invoke(parameter: AuthenticationInEntity): Flow<AuthenticationEntityType>
}

class SignInUseCaseImpl(
    private val useCase: CoroutinesUseCase,
    private val repository: AuthenticationRepository
) : SignInUseCase, UseCase<AuthenticationInEntity, AuthenticationEntityType>() {
    override suspend fun doWork(parameter: AuthenticationInEntity) =
        withContext(useCase.io()) { repository.signIn(parameter) }
}
