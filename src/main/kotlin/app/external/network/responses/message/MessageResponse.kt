package app.external.network.responses.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MessageResponse(
    @SerialName("msg")
    val message: String,
)
