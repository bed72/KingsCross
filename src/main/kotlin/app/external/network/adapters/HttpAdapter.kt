package app.external.network.adapters

import arrow.core.left
import arrow.core.right
import arrow.core.Either

import io.ktor.http.HttpHeaders
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode

import io.ktor.network.tls.CIOCipherSuites

import io.ktor.serialization.kotlinx.json.json

import io.ktor.client.call.body
import io.ktor.client.HttpClient
import io.ktor.client.request.header
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.headers
import io.ktor.client.request.request
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.statement.HttpResponse
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.engine.cio.CIOEngineConfig
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation

import app.external.environment.Environment

class HttpAdapter(private val environment: Environment) {

    private val timeout = 15000L

    val client get() = HttpClient(CIO) {
        configureLogging()
        configureRequestDefault()
        configureResponseTimeout()
        configureResponseObserver()
        configureContentNegotiation()
    }

    private fun env(resource: String) = environment.dotenv.get(resource)

    private fun HttpClientConfig<CIOEngineConfig>.configureLogging() {
        install(Logging) {
            level = LogLevel.INFO
            level = LogLevel.HEADERS
        }
    }

    private fun HttpClientConfig<CIOEngineConfig>.configureRequestDefault() {
        install(DefaultRequest) {
            url(env("url"))
            headers {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
                header("apikey", env("key"))
            }
        }
    }

    private fun HttpClientConfig<CIOEngineConfig>.configureResponseObserver() {
        install(ResponseObserver) {
            onResponse { response ->
                println("\n\n[KTOR HTTP STATUS]: ${response.status.value}\n\n")
                println("\n\n[KTOR HTTP RESPONSE]: ${response.body<String>()}\n\n")
            }
        }
    }

    private fun HttpClientConfig<CIOEngineConfig>.configureResponseTimeout() {
        install(HttpTimeout) {
            socketTimeoutMillis = timeout
            requestTimeoutMillis = timeout
            connectTimeoutMillis = timeout
        }
    }

    private fun HttpClientConfig<CIOEngineConfig>.configureContentNegotiation() {
        install(ContentNegotiation) {
            json(JsonAdapter.configure)

            engine {
                https {
                    serverName = "king's Cross"
                    cipherSuites = CIOCipherSuites.SupportedSuites
                }
            }
        }
    }
}

suspend inline fun <reified F, reified S> HttpClient.request(
    block: HttpRequestBuilder.() -> Unit,
): Either<Pair<Int, F>, Pair<Int, S>> {
    val response = request { block() }

    close()

    return when (val status = response.status) {
        HttpStatusCode.BadRequest -> failure(status.value, response)
        HttpStatusCode.Unauthorized -> failure(status.value, response)
        HttpStatusCode.TooManyRequests -> failure(status.value, response)
        HttpStatusCode.UnprocessableEntity -> failure(status.value, response)
        HttpStatusCode.OK, HttpStatusCode.Created -> success(status.value, response)
        else -> failure(status.value, response)
    }
}

suspend inline fun <reified F> failure(status: Int, response: HttpResponse) =
    (status to response.body<F>()).left()

suspend inline fun <reified S> success(status: Int, response: HttpResponse) =
    (status to response.body<S>()).right()