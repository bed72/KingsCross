package app.external.network.clients

import arrow.core.left
import arrow.core.right
import arrow.core.Either

import java.nio.file.Files
import java.nio.file.Paths

import io.ktor.http.HttpHeaders
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode

import io.ktor.network.tls.CIOCipherSuites

import io.ktor.serialization.kotlinx.json.json

import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.headers
import io.ktor.client.request.request
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.statement.HttpResponse
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.HttpClient as KtorClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.engine.cio.CIOEngineConfig
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.plugins.cache.storage.FileStorage
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation

import app.external.environment.Environment

interface HttpClient {
    operator fun invoke(): KtorClient
}

class HttpClientImpl(private val env: Environment) : HttpClient {

    private val timeout = 15000L

    override fun invoke() = KtorClient(CIO) {
        configureCache()
        configureLogging()
        configureRequestDefault()
        configureResponseTimeout()
        configureResponseObserver()
        configureContentNegotiation()
    }

    private fun HttpClientConfig<CIOEngineConfig>.configureCache() {
        install(HttpCache) {
            Files.createDirectories(Paths.get("build/cache")).toFile().run {
                publicStorage(FileStorage(this))
            }
        }
    }

    private fun HttpClientConfig<CIOEngineConfig>.configureLogging() {
        install(Logging) {
            level = LogLevel.INFO
            level = LogLevel.HEADERS
        }
    }

    private fun HttpClientConfig<CIOEngineConfig>.configureRequestDefault() {
        install(DefaultRequest) {
            url(env.get(Environment.Keys.SUPABASE_URL))
            headers {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
                header("apikey", env.get(Environment.Keys.SUPABASE_KEY))
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
            json(JsonClient.configure)

            engine {
                https {
                    serverName = "king's Cross"
                    cipherSuites = CIOCipherSuites.SupportedSuites
                }
            }
        }
    }
}

suspend inline fun <reified F, reified S> KtorClient.request(
    block: HttpRequestBuilder.() -> Unit,
): Either<Pair<Int, F>, Pair<Int, S>> {
    val response = request { block() }

    close()

    return when (val status = response.status) {
        HttpStatusCode.OK, HttpStatusCode.Created -> success(status.value, response)
        else -> failure(status.value, response)
    }
}

suspend inline fun <reified F> failure(status: Int, response: HttpResponse) =
    (status to response.body<F>()).left()

suspend inline fun <reified S> success(status: Int, response: HttpResponse) =
    (status to response.body<S>()).right()
