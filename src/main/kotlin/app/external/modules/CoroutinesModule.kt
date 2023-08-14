package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf

import app.domain.usecases.corroutine.CoroutinesUseCase
import app.domain.usecases.corroutine.CoroutinesUseCaseImpl

fun coroutineModule() = module {
    singleOf(::CoroutinesUseCaseImpl) bind CoroutinesUseCase::class
}
