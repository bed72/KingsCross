package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf

import app.external.database.clients.DatabaseClient
import app.external.database.clients.DatabaseClientImpl

fun clientModule() = module {
    singleOf(::DatabaseClientImpl) bind DatabaseClient::class
}
