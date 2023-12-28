package app.presentation.routes.authentication

import app.domain.results.Result

import org.koin.ktor.ext.inject

import io.ktor.server.routing.post
import io.ktor.server.routing.Route
import io.ktor.server.request.receive
import io.ktor.server.application.call

import app.application.dtos.toEntity
import app.application.dtos.AuthenticationInDto
import app.application.dtos.AuthenticationOutDto

import app.presentation.server.extensions.response

import app.domain.usecases.authentication.SignInUseCase

fun Route.signInRoute() {

    val useCase by inject<SignInUseCase>()

    post {
        val body = call.receive<AuthenticationInDto>()

        when (val data = body.toEntity()) {
            is Result.Failure -> call.response(messages = data.failure)
            is Result.Success -> {
                useCase(data.success).collect { response ->
                    when (response) {
                        is Result.Failure -> call.response(400, response.failure)
                        is Result.Success -> call.response(200, AuthenticationOutDto(response.success))
                    }
                }
            }
        }
    }
}
