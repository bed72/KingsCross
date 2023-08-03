package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf

import app.domain.repositories.user.UserRepository
import app.domain.repositories.user.UserRepositoryImpl

import app.domain.repositories.authentication.AuthenticationRepository
import app.domain.repositories.authentication.AuthenticationRepositoryImpl

val repositoryModule = module {
    factoryOf(::UserRepositoryImpl) bind UserRepository::class
    factoryOf(::AuthenticationRepositoryImpl) bind AuthenticationRepository::class
}
