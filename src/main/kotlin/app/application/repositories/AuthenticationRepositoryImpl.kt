package app.application.repositories

import io.ktor.http.HttpMethod
import io.ktor.client.request.url
import io.ktor.client.request.setBody

import app.domain.results.Result
import app.domain.entities.AuthenticationInEntity
import app.domain.entities.AuthenticationEntityType

import app.domain.repositories.AuthenticationRepository

import app.external.clients.http.request
import app.external.clients.http.HttpClient
import app.external.clients.http.paths.SupabasePath
import app.external.clients.http.responses.toEntity
import app.external.clients.http.responses.MessageResponse
import app.external.clients.http.requests.AuthenticationRequest
import app.external.clients.http.responses.AuthenticationResponse

class AuthenticationRepositoryImpl(private val client: HttpClient) : AuthenticationRepository {
    override suspend fun signIn(parameter: AuthenticationInEntity): AuthenticationEntityType {
        val response = client.http.request<AuthenticationResponse, MessageResponse> {
            method = HttpMethod.Post
            url(SupabasePath.SIGN_IN.value)
            setBody(AuthenticationRequest(parameter))
        }

        return when (response) {
            is Result.Success -> Result.Success(response.success.toEntity())
            is Result.Failure -> Result.Failure(response.failure.toEntity())
        }
    }
}
