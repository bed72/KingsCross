package app.domain.models.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MessageResponseModel(
    @SerialName("message")
    val message: String? = null,

    @SerialName("error_description")
    val description: String? = null
)
