package app.application.server

import kotlinx.serialization.json.Json
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi

import io.ktor.server.routing.route
import io.ktor.server.routing.Routing
import io.ktor.server.application.install
import io.ktor.server.application.Application
import io.ktor.server.plugins.cors.routing.CORS
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation

import app.application.routes.user.userRoute
import app.application.routes.health.healthCheckRoute

@OptIn(ExperimentalSerializationApi::class)
fun Application.configureServer() {
    install(CORS) {
        anyHost()
    }

    install(ContentNegotiation) {
        json(
            Json {
                explicitNulls = false
                encodeDefaults = false

                isLenient = true
                prettyPrint = true
                ignoreUnknownKeys = true
            }
        )
    }

    install(Routing) {
        route("/") {
            healthCheckRoute()
        }
        route("/v1") {
            userRoute()
        }
    }
}
