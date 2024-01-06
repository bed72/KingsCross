package app.presentation.routes.authentication

import org.koin.ktor.ext.inject

import io.ktor.server.routing.post
import io.ktor.server.routing.Route
import io.ktor.server.request.receive
import io.ktor.server.application.call

import app.presentation.server.extensions.response

import app.data.dtos.responses.toDto
import app.data.dtos.requests.toModel
import app.data.dtos.requests.AuthenticationRequestDto

import app.domain.models.ResultModel
import app.domain.usecases.authentication.SignInUseCase

fun Route.signInRoute() {

    val useCase by inject<SignInUseCase>()

    post {
        val body = call.receive<AuthenticationRequestDto>()

        when (val data = body.toModel()) {
            is ResultModel.Failure -> call.response(messages = data.failure)
            is ResultModel.Success -> {
                useCase(data.success).collect { response ->
                    when (response) {
                        is ResultModel.Failure -> call.response(400, response.failure.toDto())
                        is ResultModel.Success -> call.response(200, response.success.toDto())
                    }
                }
            }
        }
    }
}
