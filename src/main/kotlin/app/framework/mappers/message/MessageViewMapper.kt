package app.framework.mappers.message

import app.data.mappers.Mapper

import app.framework.views.message.MessageOutView

import app.external.network.responses.message.MessageResponse

class MessageViewMapper : Mapper<MessageResponse, MessageOutView> {
    override fun invoke(map: MessageResponse): MessageOutView =
        with(map) {
            error?.let { return MessageOutView(message = it) }
            message?.let { return MessageOutView(message = it) }
            description?.let { return MessageOutView(message = it) }

            return MessageOutView(message = "Ops, uma falha ocorreu.")
        }
}