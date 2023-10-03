package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf

import app.data.datasources.LocalUserDatasource
import app.external.datasources.LocalUserDatasourceImpl

val datasourceModule = module {
    factoryOf(::LocalUserDatasourceImpl) bind LocalUserDatasource::class
}
