package app.data.datasources.remote.authentication

import io.ktor.http.HttpMethod
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.client.request.url
import io.ktor.client.request.setBody

import app.domain.alias.SignUpType

import app.domain.parameters.authentication.SignUpParameter
import app.domain.parameters.authentication.SignInParameter

import app.data.mappers.remote.authentication.SignUpRemoteDatasourceMapper
import app.data.mappers.remote.authentication.SignInRemoteDatasourceMapper

import app.external.network.paths.ApiPath
import app.external.network.clients.request
import app.external.network.clients.HttpClient

import app.external.network.responses.message.MessageResponse
import app.external.network.responses.authentication.AuthenticationResponse

interface RemoteAuthenticationDatasource {
    suspend fun signUp(parameters: SignUpParameter): SignUpType
    suspend fun signIn(parameters: SignInParameter): SignUpType
}

class RemoteAuthenticationDatasourceImpl(
    private val client: HttpClient,
    private val signUpMapper: SignUpRemoteDatasourceMapper,
    private val signInMapper: SignInRemoteDatasourceMapper
) : RemoteAuthenticationDatasource {
    override suspend fun signUp(parameters: SignUpParameter): SignUpType =
        client().request<MessageResponse, AuthenticationResponse> {
            method = HttpMethod.Post
            url(ApiPath.SIGN_UP.value)
            setBody(signUpMapper(parameters))
            contentType(ContentType.Application.Json)
        }

    override suspend fun signIn(parameters: SignInParameter): SignUpType =
        client().request<MessageResponse, AuthenticationResponse> {
            method = HttpMethod.Post
            url(ApiPath.SIGN_IN.value)
            setBody(signInMapper(parameters))
            contentType(ContentType.Application.Json)
        }
}
