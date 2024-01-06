package app.data.repositories

import io.ktor.http.HttpMethod
import io.ktor.client.request.url
import io.ktor.client.request.setBody

import app.domain.models.AuthenticationType

import app.domain.repositories.AuthenticationRepository

import app.external.clients.http.request
import app.external.clients.http.HttpClient
import app.external.clients.http.paths.Path
import app.domain.models.responses.MessageResponseModel
import app.domain.models.requests.AuthenticationRequestModel
import app.domain.models.responses.AuthenticationResponseModel

class AuthenticationRepositoryImpl(private val client: HttpClient) : AuthenticationRepository {
    override suspend fun signIn(parameter: AuthenticationRequestModel): AuthenticationType =
        client.http.request<AuthenticationResponseModel, MessageResponseModel> {
            setBody(parameter)
            url(Path.SIGN_IN.value)
            method = HttpMethod.Post
        }
}
