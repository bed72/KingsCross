package app.external.modules

import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf

import app.data.mappers.authentication.SignUpDatasourceMapper
import app.data.mappers.authentication.SignInDatasourceMapper

import app.framework.mappers.message.MessageViewMapper
import app.framework.mappers.authentication.AuthenticationViewMapper

val mapperModule = module {
    // DataSources
    singleOf(::SignUpDatasourceMapper)
    singleOf(::SignInDatasourceMapper)

    // Views
    singleOf(::MessageViewMapper)
    singleOf(::AuthenticationViewMapper)
}