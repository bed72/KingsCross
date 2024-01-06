package app.presentation.routes.health

import io.ktor.http.HttpStatusCode

import io.ktor.server.routing.get
import io.ktor.server.routing.Route
import io.ktor.server.application.call

import app.data.dtos.responses.MessageResponseDto

import app.presentation.server.extensions.response

fun Route.healthCheckRoute() {
    get {
        call.response(HttpStatusCode.OK.value, MessageResponseDto("king's Cross is UP."))
    }
}
