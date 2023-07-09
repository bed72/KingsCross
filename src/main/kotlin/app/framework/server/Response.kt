package app.framework.server

import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.application.ApplicationCall

import app.framework.views.View
import app.framework.views.Status

suspend inline fun <reified T : Any> ApplicationCall.response(statusCode: Int, mapper: T) {
    val status = if (statusCode <= 207) Status.SUCCESS else Status.FAILURE
    val code = when (statusCode) {
        HttpStatusCode.OK.value -> HttpStatusCode.OK
        HttpStatusCode.Created.value -> HttpStatusCode.Created
        HttpStatusCode.NotFound.value -> HttpStatusCode.NotFound
        HttpStatusCode.BadRequest.value -> HttpStatusCode.BadRequest
        HttpStatusCode.UnprocessableEntity.value -> HttpStatusCode.UnprocessableEntity
        else -> HttpStatusCode.InternalServerError
    }

    response.status(code)

    respond(View(status, mapper))
}