package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf

import app.domain.repositories.UserRepository
import app.external.repositories.LocalUserRepository

val repositoryModule = module {

    factoryOf(::LocalUserRepository) bind UserRepository::class
}
