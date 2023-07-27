package app.framework.server

import io.ktor.http.HttpStatusCode

import io.ktor.serialization.kotlinx.json.json

import io.ktor.server.response.respond
import io.ktor.server.application.install
import io.ktor.server.application.Application
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.plugins.statuspages.StatusPagesConfig
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.plugins.requestvalidation.RequestValidationException

import app.external.network.clients.JsonClient

import app.framework.views.View
import app.framework.views.Status
import app.framework.views.message.MessageOutView
import app.framework.controllers.configureControllers

fun Application.configureServer() {

    install(ContentNegotiation) {
        json(JsonClient.configure)
    }

    install(StatusPages) {
        configureStatus(HttpStatusCode.NotFound)
        configureStatus(HttpStatusCode.BadRequest)
        configureStatus(HttpStatusCode.InternalServerError)
        configureStatus(HttpStatusCode.UnprocessableEntity)
    }

    configureControllers()

}

private fun StatusPagesConfig.configureStatus(status: HttpStatusCode) {
    exception<RequestValidationException> { call, cause ->
        call.respond(
            status,
            View(
                Status.FAILURE,
                cause.reasons.map { MessageOutView(it) },
            ),
        )
    }
}
