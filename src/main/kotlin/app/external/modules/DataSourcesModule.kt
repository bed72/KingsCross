package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf

import app.data.datasources.LocalUserDatasource
import app.external.repositories.LocalUserRepository

val datasourceModule = module {
    factoryOf(::LocalUserRepository) bind LocalUserDatasource::class
}
