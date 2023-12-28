package app.presentation.routes.authentication

import app.domain.results.Result

import org.koin.ktor.ext.inject

import io.ktor.server.routing.post
import io.ktor.server.routing.Route
import io.ktor.server.request.receive
import io.ktor.server.application.call

import app.application.dtos.toEntity
import app.application.dtos.MessageOutDto
import app.application.dtos.AuthenticationInDto
import app.application.dtos.AuthenticationOutDto

import app.presentation.server.extensions.response

import app.domain.usecases.authentication.SignInUseCase

fun Route.signInRoute() {

    val useCase by inject<SignInUseCase>()

    post {
        val body = call.receive<AuthenticationInDto>()
        val data = body.toEntity()

        useCase(data).collect { response ->
            when (response) {
                is Result.Failure -> call.response(400, MessageOutDto(response.failure))
                is Result.Success -> call.response(200, AuthenticationOutDto(response.success))
            }
        }

//        data.fold(
//            { messages -> toFailure(messages) },
//            { parameter ->
//                useCase(parameter).collect { response ->
//                    response.fold(
//                        { failure -> call.response(400, MessageDto.toDto(failure)) },
//                        { success -> call.response(201, UserDto.toDto(success)) }
//                    )
//                }
//            }
//        )
    }
}
