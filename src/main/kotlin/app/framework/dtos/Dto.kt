package app.framework.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dto<out T>(
    @SerialName("status")
    val status: Status,

    @SerialName("data")
    val data: T,
)

@Serializable
enum class Status {
    SUCCESS,
    FAILURE
}
