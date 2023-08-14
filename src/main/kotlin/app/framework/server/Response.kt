package app.framework.server

import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.application.ApplicationCall

import app.framework.views.View
import app.framework.views.Status
import app.framework.views.message.MessageOutView

suspend inline fun <reified T : Any> ApplicationCall.response(statusCode: Int, mapper: T) {
    val (code, status) = handlerStatus(statusCode)

    response.status(code)

    respond(View(status, mapper))
}

suspend inline fun ApplicationCall.response(statusCode: Int = 422, messages: List<String>) {
    val (code, status) = handlerStatus(statusCode)

    response.status(code)

    respond(View(status, messages.map { MessageOutView(it) }))
}

fun handlerStatus(statusCode: Int): Pair<HttpStatusCode, Status> {
    val status = if (statusCode <= HttpStatusCode.MultiStatus.value) Status.SUCCESS else Status.FAILURE

    return when (statusCode) {
        HttpStatusCode.OK.value -> HttpStatusCode.OK
        HttpStatusCode.Created.value -> HttpStatusCode.Created
        HttpStatusCode.NotFound.value -> HttpStatusCode.NotFound
        HttpStatusCode.BadRequest.value -> HttpStatusCode.BadRequest
        HttpStatusCode.UnprocessableEntity.value -> HttpStatusCode.UnprocessableEntity
        else -> HttpStatusCode.InternalServerError
    } to status
}
