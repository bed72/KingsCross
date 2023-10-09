package app.domain.entities

sealed class ApplicationMessage(open val message: String?) {
    override fun toString(): String = message ?: "null"
}

data class Message(override val message: String) : ApplicationMessage(message)
