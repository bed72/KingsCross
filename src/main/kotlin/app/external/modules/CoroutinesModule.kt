package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf

import app.application.usecases.corroutine.CoroutinesUseCase
import app.application.usecases.corroutine.CoroutinesUseCaseImpl

fun coroutineModule() = module {
    singleOf(::CoroutinesUseCaseImpl) bind CoroutinesUseCase::class

}
