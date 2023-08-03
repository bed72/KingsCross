package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf

import app.domain.datasources.local.user.LocalUserDatasource
import app.data.datasources.local.user.LocalUserDatasourceImpl

import app.domain.datasources.remote.authentication.RemoteAuthenticationDatasource
import app.data.datasources.remote.authentication.RemoteAuthenticationDatasourceImpl

val datasourceModule = module {
    factoryOf(::LocalUserDatasourceImpl) bind LocalUserDatasource::class
    factoryOf(::RemoteAuthenticationDatasourceImpl) bind RemoteAuthenticationDatasource::class
}
