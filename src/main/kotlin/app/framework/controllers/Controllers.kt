package app.framework.controllers

import io.ktor.server.routing.route
import io.ktor.server.routing.routing

import io.ktor.server.application.Application

import app.framework.controllers.health.healthCheckController
import app.framework.controllers.authentication.signUpController
import app.framework.controllers.authentication.signInController

fun Application.configureControllers() {
    routing {
        route("/") {
            healthCheckController()
        }

        route("/v1/authentication") {
            signUpController()
            signInController()
        }
    }
}
