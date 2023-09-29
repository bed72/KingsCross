package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf

import app.domain.repositories.UserRepository
import app.data.repositories.UserRepositoryImpl

val repositoryModule = module {
    factoryOf(::UserRepositoryImpl) bind UserRepository::class
}
