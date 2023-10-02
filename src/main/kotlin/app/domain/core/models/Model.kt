package app.domain.core.models

interface Model {
    fun hasMessage(): MutableSet<String?>
}
