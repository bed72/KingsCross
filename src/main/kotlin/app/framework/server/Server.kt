package app.framework.server

import io.ktor.serialization.kotlinx.json.json

import io.ktor.server.routing.route
import io.ktor.server.routing.Routing
import io.ktor.server.application.install
import io.ktor.server.application.Application
import io.ktor.server.plugins.cors.routing.CORS
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation

import app.external.network.clients.JsonClient

import app.framework.routes.health.healthCheckRoute
import app.framework.routes.authentication.signUpRoute
import app.framework.routes.authentication.signInRoute

fun Application.configureServer() {
    install(CORS) {
        anyHost()
    }

    install(ContentNegotiation) {
        json(JsonClient.configure)
    }

    install(Routing) {
        route("/") {
            healthCheckRoute()
        }
        route("/v1/authentication") {
            signUpRoute()
            signInRoute()
        }
    }
}
