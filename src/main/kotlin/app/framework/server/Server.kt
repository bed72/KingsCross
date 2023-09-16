package app.framework.server

import com.apurebase.kgraphql.GraphQL

import io.ktor.serialization.kotlinx.json.json

import io.ktor.server.routing.route
import io.ktor.server.routing.routing
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

    install(GraphQL) {
        playground = true
        routing {
            route("/") {
                healthCheckRoute()
            }
            route("/v1/authentication") {
                signUpRoute()
                signInRoute()
            }
        }
        schema {
            query("hello") {
                resolver { -> "World!" }
            }
        }
    }
}
