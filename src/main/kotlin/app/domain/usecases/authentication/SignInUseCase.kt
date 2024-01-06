package app.domain.usecases.authentication

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

import app.domain.usecases.UseCase
import app.domain.usecases.corroutine.CoroutinesUseCase

import app.domain.repositories.AuthenticationRepository

import app.domain.models.AuthenticationType
import app.domain.models.requests.AuthenticationRequestModel

interface SignInUseCase {
    operator fun invoke(parameter: AuthenticationRequestModel): Flow<AuthenticationType>
}

class SignInUseCaseImpl(
    private val useCase: CoroutinesUseCase,
    private val repository: AuthenticationRepository
) : SignInUseCase, UseCase<AuthenticationRequestModel, AuthenticationType>() {
    override suspend fun doWork(parameter: AuthenticationRequestModel) =
        withContext(useCase.io()) { repository.signIn(parameter) }
}
