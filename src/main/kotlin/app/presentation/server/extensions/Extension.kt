package app.presentation.server.extensions

import io.ktor.http.HttpStatusCode

import io.ktor.server.response.respond
import io.ktor.server.application.ApplicationCall

import app.application.dtos.Dto
import app.application.dtos.Status
import app.application.dtos.MessageOutDto

suspend inline fun <reified T : Any> ApplicationCall.response(statusCode: Int = 200, adapter: T) {
    val (code, status) = handlerStatus(statusCode)

    response.status(code)

    respond(Dto(status, adapter))
}

suspend inline fun ApplicationCall.response(statusCode: Int = 422, message: MessageOutDto) {
    val (code, status) = handlerStatus(statusCode)

    response.status(code)

    respond(Dto(status, message))
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
