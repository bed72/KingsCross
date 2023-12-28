package app.presentation.routes.health

import io.ktor.http.HttpStatusCode

import io.ktor.server.routing.get
import io.ktor.server.routing.Route
import io.ktor.server.application.call

import app.application.dtos.MessageOutDto

import app.presentation.server.extensions.response

fun Route.healthCheckRoute() {
    get {
        call.response(HttpStatusCode.OK.value, MessageOutDto("king's Cross is UP."))
    }
}
