package app.external.modules

import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf

import app.framework.mappers.UserMapper
import app.framework.mappers.MessageMapper

val mappersModule = module {
    factoryOf(::UserMapper)

    factoryOf(::MessageMapper)
}