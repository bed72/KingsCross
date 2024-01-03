package app.external.clients.http.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import app.domain.entities.MessageOutEntity

@Serializable
data class MessageResponse(
    @SerialName("msg")
    val message: String?,

    @SerialName("error")
    val error: String?,

    @SerialName("error_description")
    val errorDescription: String?
)

fun MessageResponse.toEntity() = MessageOutEntity(
    message ?: "Ops um erro ocorreu.",
    error,
    errorDescription
)
