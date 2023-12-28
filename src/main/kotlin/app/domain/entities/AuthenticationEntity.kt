package app.domain.entities

data class AuthenticationInEntity(
    val email: String,
    val password: String
)

data class AuthenticationOutEntity(
    val expireIn: Int,
    val name: String?,
    val email: String,
    val accessToken: String,
    val refreshToken: String
)
