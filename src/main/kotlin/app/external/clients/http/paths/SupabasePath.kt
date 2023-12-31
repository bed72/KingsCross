package app.external.clients.http.paths

enum class SupabasePath(val value: String) {
    LOGOUT("/auth/v1/logout"),
    GET_USER("/auth/v1/user"),
    SIGN_UP("/auth/v1/signup"),
    SIGN_IN("/auth/v1/token?grant_type=password"),
    USER_IMAGES("/storage/v1/object/images/users/"),
    REFRESH_TOKEN("/auth/v1/token?grant_type=refresh_token")
}