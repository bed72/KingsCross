package app.framework.mappers

import app.domain.core.models.MessageModel

import app.framework.mappers.Mapper
import app.framework.dtos.MessageDto

class MessageMapper : Mapper<MessageModel, MessageDto> {
    override fun invoke(model: MessageModel) = MessageDto(model.message)
}
