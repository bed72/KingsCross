package app.application.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import app.domain.entities.MessageOutEntity

@Serializable
data class MessageOutDto(
    @SerialName("message")
    val message: String
) {
    companion object {
        operator fun invoke(data: MessageOutEntity) = MessageOutDto(message = data.message)
    }
}
