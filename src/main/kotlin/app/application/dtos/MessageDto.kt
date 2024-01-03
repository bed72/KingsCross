package app.application.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import app.domain.entities.MessageOutEntity

@Serializable
data class MessageOutDto(
    @SerialName("message")
    val message: String,

    @SerialName("error")
    val error: String? = null,

    @SerialName("description")
    val description: String? = null
) {
    companion object {
        operator fun invoke(data: MessageOutEntity) =
            MessageOutDto(message = data.message, error = data.error, description = data.errorDescription)
    }
}
