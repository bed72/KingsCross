package app.data.datasources.authentication

import io.ktor.http.HttpMethod
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.client.request.url
import io.ktor.client.request.setBody

import app.domain.alias.SignUpType

import app.domain.parameters.authentication.SignUpParameter
import app.domain.parameters.authentication.SignInParameter

import app.data.mappers.authentication.SignUpDatasourceMapper
import app.data.mappers.authentication.SignInDatasourceMapper

import app.external.network.paths.ApiPath
import app.external.network.adapters.request
import app.external.network.adapters.HttpAdapter

import app.external.network.responses.message.MessageResponse
import app.external.network.responses.authentication.AuthenticationResponse

interface AuthenticationDatasource {
    suspend fun signUp(parameters: SignUpParameter): SignUpType
    suspend fun signIn(parameters: SignInParameter): SignUpType
}

class AuthenticationDatasourceImpl(
    private val adapter: HttpAdapter,
    private val signUpMapper: SignUpDatasourceMapper,
    private val signInMapper: SignInDatasourceMapper
) : AuthenticationDatasource {
    override suspend fun signUp(parameters: SignUpParameter): SignUpType =
        adapter.client.request<MessageResponse, AuthenticationResponse> {
            method = HttpMethod.Post
            url(ApiPath.SIGN_UP.value)
            setBody(signUpMapper(parameters))
            contentType(ContentType.Application.Json)
        }

    override suspend fun signIn(parameters: SignInParameter): SignUpType =
        adapter.client.request<MessageResponse, AuthenticationResponse> {
            method = HttpMethod.Post
            url(ApiPath.SIGN_IN.value)
            setBody(signInMapper(parameters))
            contentType(ContentType.Application.Json)
        }
}
