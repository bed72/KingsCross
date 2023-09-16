package app.data.datasources.remote.authentication

import io.ktor.http.HttpMethod
import io.ktor.client.request.url
import io.ktor.client.request.setBody

import app.data.mappers.remote.authentication.SignUpRemoteDatasourceMapper
import app.data.mappers.remote.authentication.SignInRemoteDatasourceMapper

import app.external.network.paths.ApiPath
import app.external.network.clients.request
import app.external.network.clients.HttpClient

import app.external.network.responses.message.MessageResponse
import app.external.network.responses.authentication.AuthenticationResponse

import app.domain.alias.SignUpType

import app.domain.parameters.authentication.SignUpParameter
import app.domain.parameters.authentication.SignInParameter

import app.domain.datasources.remote.authentication.RemoteAuthenticationDatasource

class RemoteAuthenticationDatasourceImpl(
    private val client: HttpClient,
    private val signUpMapper: SignUpRemoteDatasourceMapper,
    private val signInMapper: SignInRemoteDatasourceMapper
) : RemoteAuthenticationDatasource {
    override suspend fun signUp(parameter: SignUpParameter): SignUpType =
        client().request<MessageResponse, AuthenticationResponse> {
            method = HttpMethod.Post
            url(ApiPath.SIGN_UP.value)
            setBody(signUpMapper(parameter))
        }

    override suspend fun signIn(parameter: SignInParameter): SignUpType =
        client().request<MessageResponse, AuthenticationResponse> {
            method = HttpMethod.Post
            url(ApiPath.SIGN_IN.value)
            setBody(signInMapper(parameter))
        }
}
