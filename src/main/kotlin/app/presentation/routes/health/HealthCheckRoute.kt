package app.presentation.routes.health

import io.ktor.http.HttpStatusCode

import io.ktor.server.routing.get
import io.ktor.server.routing.Route
import io.ktor.server.application.call

import app.presentation.server.response.response
import app.application.dtos.MessageDto

fun Route.healthCheckRoute() {
    get {
        call.response(HttpStatusCode.OK.value, MessageDto("king's Cross is UP."))
    }
}
