package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf

import app.domain.datasources.LocalUserDatasource
import app.data.datasources.LocalUserDatasourceImpl

val datasourceModule = module {
    factoryOf(::LocalUserDatasourceImpl) bind LocalUserDatasource::class
}
