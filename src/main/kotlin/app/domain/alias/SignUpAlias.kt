package app.domain.alias

import arrow.core.Either

import app.external.network.responses.message.MessageResponse
import app.external.network.responses.authentication.SignUpResponse

typealias SignUpType = Either<Pair<Int, MessageResponse>, Pair<Int, SignUpResponse>>