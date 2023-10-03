package app.application.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MessageDto(
    @SerialName("message")
    val message: String
)
