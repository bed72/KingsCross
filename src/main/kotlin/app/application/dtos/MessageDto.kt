package app.application.dtos

import app.domain.entities.Message
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MessageDto(
    @SerialName("message")
    val message: String
) {
    companion object {
        operator fun invoke(model: Message) = MessageDto(message = model.message)
    }
}
