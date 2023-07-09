package app.framework.views

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class View<out T>(
    @SerialName("status_code")
    val status: Status = Status.SUCCESS,

    @SerialName("data")
    val data: T,
)

@Serializable
enum class Status {
    SUCCESS,
    FAILURE
}