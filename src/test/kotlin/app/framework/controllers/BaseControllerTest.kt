package app.framework.controllers

import io.ktor.server.testing.testApplication
import io.ktor.server.config.ApplicationConfig

import io.ktor.server.testing.ApplicationTestBuilder

fun <R> withBaseTestApplication(runTest: suspend ApplicationTestBuilder.() -> R) {
    testApplication {

        environment {
            config = ApplicationConfig("application-test.conf")
        }

        runTest()
    }
}