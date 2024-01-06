package app.data.dtos.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import app.domain.models.responses.MessageResponseModel

@Serializable
data class MessageResponseDto(
    @SerialName("message")
    val message: String? = "Oops! Algo deu um passeio fora dos trilhos.",

    @SerialName("description")
    val description: String? = "Parece que algo deu errado. Relaxa por um momento, logo estaremos de volta nos trilhos."
)

fun MessageResponseModel.toDto() = MessageResponseDto(message = message, description = description)
