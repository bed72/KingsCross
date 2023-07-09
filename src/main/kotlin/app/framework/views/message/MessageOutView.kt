package app.framework.views.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MessageOutView(
    @SerialName("message")
    val message: String
)
