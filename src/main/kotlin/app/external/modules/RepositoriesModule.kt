package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf

import app.data.repositories.user.UserRepository
import app.data.repositories.user.UserRepositoryImpl

import app.data.repositories.authentication.AuthenticationRepository
import app.data.repositories.authentication.AuthenticationRepositoryImpl

val repositoryModule = module {
    factoryOf(::UserRepositoryImpl) bind UserRepository::class
    factoryOf(::AuthenticationRepositoryImpl) bind AuthenticationRepository::class
}
