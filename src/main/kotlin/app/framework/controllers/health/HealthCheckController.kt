package app.framework.controllers.health

import io.ktor.http.HttpStatusCode

import io.ktor.server.routing.get
import io.ktor.server.routing.Route
import io.ktor.server.application.call

import app.framework.server.response
import app.framework.views.message.MessageOutView

fun Route.healthCheckController() {
    get {
        call.response(HttpStatusCode.OK.value, MessageOutView("king's Cross is UP. The documentation path is /doc"))
    }
}