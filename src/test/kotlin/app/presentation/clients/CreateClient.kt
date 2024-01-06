package app.presentation.clients

import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.testing.ApplicationTestBuilder

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation

import app.external.clients.evironment.EnvironmentClient
import app.external.clients.evironment.EnvironmentClientImpl

fun ApplicationTestBuilder.env(): EnvironmentClient = EnvironmentClientImpl()

fun ApplicationTestBuilder.client(): HttpClient = createClient {
    install(ContentNegotiation) { json() }
}
