package app.domain.entities


data class MessageOutEntity(
    val message: String,
    val error: String? = null,
    val errorDescription: String? = null
)
