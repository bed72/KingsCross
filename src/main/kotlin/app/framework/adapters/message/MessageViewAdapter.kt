package app.framework.adapters.message

import app.data.adapters.Adapter

import app.domain.core.models.MessageModel

import app.framework.dtos.message.MessageDto

class MessageViewAdapter : Adapter<MessageModel, MessageDto> {
    override fun invoke(data: MessageModel) = MessageDto(data.message)
}
