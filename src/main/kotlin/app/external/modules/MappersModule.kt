package app.external.modules

import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf

import app.data.mappers.local.user.UserLocalDatasourceMapper

import app.data.mappers.remote.authentication.SignUpRemoteDatasourceMapper
import app.data.mappers.remote.authentication.SignInRemoteDatasourceMapper

import app.framework.mappers.message.MessageViewMapper
import app.framework.mappers.authentication.AuthenticationViewMapper

val mapperModule = module {
    // LocalDataSource
    factoryOf(::UserLocalDatasourceMapper)

    // RemoteDataSources
    factoryOf(::SignUpRemoteDatasourceMapper)
    factoryOf(::SignInRemoteDatasourceMapper)

    // Views
    factoryOf(::MessageViewMapper)
    factoryOf(::AuthenticationViewMapper)
}