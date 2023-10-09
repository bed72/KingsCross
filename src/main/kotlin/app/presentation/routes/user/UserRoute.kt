package app.presentation.routes.user

import app.application.dtos.MessageDto
import arrow.core.NonEmptyList

import org.koin.ktor.ext.inject

import io.ktor.server.routing.post
import io.ktor.server.routing.Route
import io.ktor.server.request.receive
import io.ktor.server.application.call

import app.application.dtos.toModel
import app.application.dtos.UserDto

import app.presentation.server.extensions.response

import app.domain.entities.Message
import app.domain.usecases.user.UserCreateUseCase
import app.presentation.server.extensions.toFailure

fun Route.userRoute() {

    val useCase by inject<UserCreateUseCase>()

    post("/user") {
        val body = call.receive<UserDto>()
        val data = body.toModel()

        data.fold(
            { messages -> toFailure(messages) },
            { parameter ->
                useCase(parameter).collect { response ->
                    response.fold(
                        { failure -> call.response(400, MessageDto(failure)) },
                        { success -> call.response(201, UserDto.toDto(success)) }
                    )
                }
            }
        )
    }
}
