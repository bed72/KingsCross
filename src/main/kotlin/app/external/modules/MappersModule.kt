package app.external.modules

import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf

import app.framework.mappers.message.MessageViewMapper
import app.framework.mappers.authentication.SignUpViewMapper
import app.data.mappers.authentication.SignUpDatasourceMapper

val mapperModule = module {
    // Views
    singleOf(::SignUpViewMapper)
    singleOf(::MessageViewMapper)

    // DataSources
    singleOf(::SignUpDatasourceMapper)
}