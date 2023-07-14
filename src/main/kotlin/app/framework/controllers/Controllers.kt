package app.framework.controllers

import io.ktor.server.routing.route
import io.ktor.server.routing.routing

import io.ktor.server.application.install
import io.ktor.server.application.Application

import io.ktor.server.plugins.swagger.swaggerUI
import io.ktor.server.plugins.requestvalidation.RequestValidation

import app.framework.controllers.health.healthCheckController
import app.framework.controllers.authentication.signUpController
import app.framework.controllers.authentication.signInController

fun Application.configureControllers() {
    install(RequestValidation) {
        routing {

            swaggerUI(path = "doc", swaggerFile = "src/main/resources/documentation.yaml") {
                version = "1.0.0"
            }

            route("/") {
                healthCheckController()
            }

            route("/v1/authentication") {
                signUpController(this@install)
                signInController(this@install)
            }
        }
    }
}