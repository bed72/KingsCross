package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf

import app.domain.usecases.user.UserCreateUseCase
import app.application.usecases.user.UserCreateUseCaseImpl

val useCaseModule = module {
    singleOf(::UserCreateUseCaseImpl) bind UserCreateUseCase::class
}
