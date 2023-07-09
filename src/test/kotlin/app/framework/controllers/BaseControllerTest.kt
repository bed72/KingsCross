package app.framework.controllers

import io.ktor.server.testing.testApplication
import io.ktor.server.testing.ApplicationTestBuilder

fun <R> withBaseTestApplication(runTest: suspend ApplicationTestBuilder.() -> R) {
    testApplication {

//        install(ContentNegotiation) {
//            json(JsonAdapter.configure, contentType = ContentType.Application.Json)
//        }

//        environment {
//            config = MapApplicationConfig("ktor.environment" to "test")
//        }

        runTest()
    }
}