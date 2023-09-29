package app.framework.routes.user

import org.koin.ktor.ext.inject

import io.ktor.server.routing.post
import io.ktor.server.routing.Route
import io.ktor.server.request.receive
import io.ktor.server.application.call

import app.framework.dtos.user.toModel
import app.framework.dtos.user.UserInDto
import app.framework.server.response.response

import app.domain.usecases.user.UserCreateUseCase

import app.framework.adapters.user.UserViewAdapter
import app.framework.adapters.message.MessageViewAdapter

fun Route.userRoute() {

    val useCase by inject<UserCreateUseCase>()

    val success by inject<UserViewAdapter>()
    val failure by inject<MessageViewAdapter>()

    post("/user") {
        val body = call.receive<UserInDto>()
        val parameter = body.toModel().isValid()

        if (parameter.isNotEmpty()) call.response(messages = parameter)
        else useCase(body.toModel()).collect { response ->
            response.fold(
                { failure -> call.response(400, failure(failure)) },
                { success -> call.response(201, success(success)) }
            )
        }
    }
}
