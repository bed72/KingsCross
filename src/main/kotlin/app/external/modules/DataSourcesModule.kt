package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf

import app.data.datasources.authentication.AuthenticationDatasource
import app.data.datasources.authentication.AuthenticationDatasourceImpl

val datasourceModule = module {
    factoryOf(::AuthenticationDatasourceImpl) bind AuthenticationDatasource::class
}
