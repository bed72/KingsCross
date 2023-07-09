package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf

import app.data.repositories.authentication.SignUpRepository
import app.data.repositories.authentication.SignUpRepositoryImpl


val repositoryModule = module {
    singleOf(::SignUpRepositoryImpl) bind SignUpRepository::class
}
