package app.domain.entities.types

import arrow.core.Either

import app.domain.entities.User
import app.domain.entities.Message

typealias CreateUserType = Either<Message, User>