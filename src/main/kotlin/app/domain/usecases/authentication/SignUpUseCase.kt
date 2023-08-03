package app.domain.usecases.authentication

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

import app.domain.alias.SignUpType
import app.domain.usecases.UseCase
import app.domain.usecases.corroutine.CoroutinesUseCase
import app.domain.parameters.authentication.SignUpParameter

import app.domain.repositories.authentication.AuthenticationRepository

interface SignUpUseCase {
    operator fun invoke(parameters: SignUpParameter): Flow<SignUpType>
}

class SignUpUseCaseImpl(
    private val useCase: CoroutinesUseCase,
    private val repository: AuthenticationRepository,
) : SignUpUseCase, UseCase<SignUpParameter, SignUpType>() {
    override suspend fun doWork(parameters: SignUpParameter): SignUpType =
        withContext(useCase.io()) { repository.signUp(parameters) }
}
