package app.domain.values

import arrow.core.Either

sealed interface ValueObject {
    operator fun invoke(): Either<String, String>
}
