package app.framework.mappers.message

import app.data.mappers.Mapper

import app.framework.views.message.MessageOutView

import app.external.network.responses.message.MessageResponse

class MessageViewMapper : Mapper<MessageResponse, MessageOutView> {
    override fun invoke(map: MessageResponse): MessageOutView = when {
        map.error?.isNotEmpty() == true -> MessageOutView(map.error)
        map.message?.isNotEmpty() == true -> MessageOutView(map.message)
        map.description?.isNotEmpty() == true -> MessageOutView(map.description)
        else -> MessageOutView("Ops, uma falha ocorreu.")
    }
}