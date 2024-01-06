package app.domain.models.values

enum class MessagesValues(val message: String) {
    INVALID_NAME("Preencha um nome válido."),
    INVALID_EMAIL("Preencha um e-mail válido."),
    INVALID_PASSWORD("Preencha uma senha válida com no mínimo 6 caracteres, contendo uma combinação de letras maiúsculas, minúsculas e números.")
}