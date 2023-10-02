package app.domain.core.types

import arrow.core.Either

import app.domain.core.models.UserModel
import app.domain.core.models.MessageModel

typealias CreateUserType = Either<MessageModel, UserModel>