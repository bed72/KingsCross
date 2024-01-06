package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf

import app.domain.repositories.AuthenticationRepository
import app.data.repositories.AuthenticationRepositoryImpl

val repositoryModule = module {
    factoryOf(::AuthenticationRepositoryImpl) bind AuthenticationRepository::class
}
