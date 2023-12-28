package app.domain.results

sealed class Result<out S, out F,> {
    data class Success<out S>(val success: S) : Result<S, Nothing>()
    data class Failure<out F>(val failure: F) : Result<Nothing, F>()

    override fun toString() = when (this) {
        is Success<*> -> "Success: [$success]"
        is Failure<*> -> "Failure: [$failure]"
    }
}
