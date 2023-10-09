package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf

import app.external.clients.database.DatabaseClient
import app.external.clients.database.DatabaseClientImpl

import app.external.clients.evironment.EnvironmentClient
import app.external.clients.evironment.EnvironmentClientImpl

fun clientsModule() = module {
    singleOf(::DatabaseClientImpl) bind DatabaseClient::class
    singleOf(::EnvironmentClientImpl) bind EnvironmentClient::class
}
