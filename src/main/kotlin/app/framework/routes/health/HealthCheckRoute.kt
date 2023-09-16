package app.framework.routes.health

import io.ktor.http.HttpStatusCode

import io.ktor.server.routing.get
import io.ktor.server.routing.Route
import io.ktor.server.application.call

import app.framework.views.response.response
import app.framework.views.message.MessageOutView

fun Route.healthCheckRoute() {
    get {
        call.response(HttpStatusCode.OK.value, MessageOutView("king's Cross is UP."))
    }
}
