package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf

import app.external.clients.DatabaseClient
import app.external.clients.DatabaseClientImpl

import app.external.clients.EnvironmentClient
import app.external.clients.EnvironmentClientImpl

fun clientsModule() = module {
    singleOf(::DatabaseClientImpl) bind DatabaseClient::class
    singleOf(::EnvironmentClientImpl) bind EnvironmentClient::class
}
