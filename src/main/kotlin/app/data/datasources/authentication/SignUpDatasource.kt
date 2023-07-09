package app.data.datasources.authentication

import io.ktor.http.HttpMethod
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.client.request.url
import io.ktor.client.request.setBody

import app.domain.alias.SignUpType

import app.domain.parameters.authentication.SignUpParameter

import app.data.mappers.authentication.SignUpDatasourceMapper

import app.external.network.paths.ApiPath
import app.external.network.adapters.request
import app.external.network.adapters.HttpAdapter

import app.external.network.responses.message.MessageResponse
import app.external.network.responses.authentication.SignUpResponse

interface SignUpDatasource {
    suspend operator fun invoke(parameters: SignUpParameter): SignUpType
}

class SignUpDatasourceImpl(
    private val adapter: HttpAdapter,
    private val mapper: SignUpDatasourceMapper
) : SignUpDatasource {
    override suspend fun invoke(parameters: SignUpParameter): SignUpType {
        val response = adapter.client.request<MessageResponse, SignUpResponse> {
            method = HttpMethod.Post
            url(ApiPath.SIGN_UP.value)
            setBody(mapper(parameters))
            contentType(ContentType.Application.Json)
        }

        return response
    }
}
