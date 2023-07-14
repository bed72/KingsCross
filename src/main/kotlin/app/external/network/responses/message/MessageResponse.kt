package app.external.network.responses.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MessageResponse(
    @SerialName("error")
    val error: String?,

    @SerialName("msg")
    val message: String?,

    @SerialName("error_description")
    val description: String?,
)
