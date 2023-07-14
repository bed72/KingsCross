package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf

import app.domain.usecases.authentication.SignUpUseCase
import app.domain.usecases.authentication.SignUpUseCaseImpl

import app.domain.usecases.authentication.SignInUseCase
import app.domain.usecases.authentication.SignInUseCaseImpl

val useCaseModule = module {
    singleOf(::SignUpUseCaseImpl) bind SignUpUseCase::class
    singleOf(::SignInUseCaseImpl) bind SignInUseCase::class
}
