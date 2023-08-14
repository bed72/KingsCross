package app.framework.views.authentication

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthenticationOutView(
    @SerialName("expires_in")
    val expireIn: Int,

    @SerialName("access_token")
    val accessToken: String,

    @SerialName("refresh_token")
    val refreshToken: String,

    @SerialName("name")
    val name: String,

    @SerialName("email")
    val email: String,
)
