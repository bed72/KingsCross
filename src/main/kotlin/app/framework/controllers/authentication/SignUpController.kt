package app.framework.controllers.authentication

import org.koin.ktor.ext.inject

import io.ktor.server.routing.post
import io.ktor.server.routing.Route
import io.ktor.server.request.receive
import io.ktor.server.application.call

import app.domain.usecases.authentication.SignUpUseCase

import app.framework.server.response

import app.framework.views.authentication.toParameter
import app.framework.views.authentication.SignUpInView

import app.framework.mappers.message.MessageViewMapper
import app.framework.mappers.authentication.AuthenticationViewMapper

fun Route.signUpController() {

    val useCase by inject<SignUpUseCase>()
    val failure by inject<MessageViewMapper>()
    val success by inject<AuthenticationViewMapper>()

    post("/sign/up") {
        val body = call.receive<SignUpInView>()
        val parameters = body.toParameter()

        parameters.isValid().fold(
            { messages -> call.response(messages = messages) },
            { parameter ->
                useCase(parameter).collect { response ->
                    response.fold(
                        { (status, data) -> call.response(status, failure(data)) },
                        { (status, data) -> call.response(status, success(data)) },
                    )
                }
            }
        )
    }
}
