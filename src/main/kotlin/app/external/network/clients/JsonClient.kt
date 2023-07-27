package app.external.network.clients

import kotlinx.serialization.json.Json

import kotlinx.serialization.ExperimentalSerializationApi

@OptIn(ExperimentalSerializationApi::class)
class JsonClient {
    companion object {
        val configure get() = Json {
            explicitNulls = false
            encodeDefaults = false

            isLenient = true
            prettyPrint = true
            ignoreUnknownKeys = true
        }
    }
}