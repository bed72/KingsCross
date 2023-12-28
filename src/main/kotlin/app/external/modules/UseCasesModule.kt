package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf

import app.domain.usecases.corroutine.CoroutinesUseCase
import app.domain.usecases.corroutine.CoroutinesUseCaseImpl

import app.domain.usecases.authentication.SignInUseCase
import app.domain.usecases.authentication.SignInUseCaseImpl

fun coroutinesModule() = module {
    singleOf(::CoroutinesUseCaseImpl) bind CoroutinesUseCase::class
}

val useCaseModule = module {
    singleOf(::SignInUseCaseImpl) bind SignInUseCase::class
}
