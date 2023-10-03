package app.application.routes.user

import org.koin.ktor.ext.inject

import io.ktor.server.routing.post
import io.ktor.server.routing.Route
import io.ktor.server.request.receive
import io.ktor.server.application.call

import app.application.dtos.toModel
import app.application.dtos.UserDto
import app.application.server.response.response

import app.domain.usecases.user.UserCreateUseCase

import app.application.mappers.UserMapper
import app.application.mappers.MessageMapper

fun Route.userRoute() {

    val useCase by inject<UserCreateUseCase>()

    val success by inject<UserMapper>()
    val failure by inject<MessageMapper>()

    post("/user") {
        val body = call.receive<UserDto>()
        val parameter = body.toModel().hasMessage()

        if (parameter.isNotEmpty()) call.response(messages = parameter)
        else useCase(body.toModel()).collect { response ->
            response.fold(
                { failure -> call.response(400, failure(failure)) },
                { success -> call.response(201, success(success)) }
            )
        }
    }
}
