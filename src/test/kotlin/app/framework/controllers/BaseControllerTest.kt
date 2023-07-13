package app.framework.controllers

import io.ktor.server.testing.testApplication
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.config.ApplicationConfig
import io.ktor.server.testing.ApplicationTestBuilder

import io.ktor.client.plugins.contentnegotiation.ContentNegotiation

fun ApplicationTestBuilder.request() = createClient {
    install(ContentNegotiation) {
        json()
    }
}

fun <R> withBaseTestApplication(runTest: suspend ApplicationTestBuilder.() -> R) {
    testApplication {

        environment {
            config = ApplicationConfig("application-test.conf")
        }

        runTest()
    }
}