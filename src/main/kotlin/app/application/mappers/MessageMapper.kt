package app.application.mappers

import app.domain.core.models.MessageModel

import app.application.dtos.MessageDto

class MessageMapper : Mapper<MessageModel, MessageDto> {
    override fun invoke(model: MessageModel) = MessageDto(model.message)
}
