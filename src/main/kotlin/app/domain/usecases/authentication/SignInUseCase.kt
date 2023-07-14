package app.domain.usecases.authentication

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

import app.domain.alias.SignUpType
import app.domain.usecases.UseCase
import app.domain.usecases.corroutine.CoroutinesUseCase
import app.domain.parameters.authentication.SignInParameter

import app.data.repositories.authentication.AuthenticationRepository

interface SignInUseCase {
    operator fun invoke(parameters: SignInParameter): Flow<SignUpType>
}

class SignInUseCaseImpl(
    private val useCase: CoroutinesUseCase,
    private val repository: AuthenticationRepository,
) : SignInUseCase, UseCase<SignInParameter, SignUpType>() {
    override suspend fun doWork(parameters: SignInParameter): SignUpType =
        withContext(useCase.io()) { repository.signIn(parameters) }
}
