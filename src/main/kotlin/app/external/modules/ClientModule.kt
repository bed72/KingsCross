package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf

import app.external.clients.http.HttpClient
import app.external.clients.http.HttpClientImpl

import app.external.clients.evironment.EnvironmentClient
import app.external.clients.evironment.EnvironmentClientImpl

fun clientsModule() = module {
    singleOf(::HttpClientImpl) bind HttpClient::class
    singleOf(::EnvironmentClientImpl) bind EnvironmentClient::class
}
