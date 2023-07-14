package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf

import app.data.repositories.authentication.AuthenticationRepository
import app.data.repositories.authentication.AuthenticationRepositoryImpl


val repositoryModule = module {
    singleOf(::AuthenticationRepositoryImpl) bind AuthenticationRepository::class
}
