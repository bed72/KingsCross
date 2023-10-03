package app.external.modules

import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf

import app.application.mappers.UserMapper
import app.application.mappers.MessageMapper

val mappersModule = module {
    factoryOf(::UserMapper)

    factoryOf(::MessageMapper)
}