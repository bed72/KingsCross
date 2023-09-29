package app.domain.core.models

interface Model {
    fun isValid(): MutableSet<String?>
}
