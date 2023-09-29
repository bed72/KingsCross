package app.domain.core.types

import arrow.core.Either

import app.domain.core.models.MessageModel
import app.domain.core.models.UserOutModel

typealias UserType = Either<MessageModel, UserOutModel>