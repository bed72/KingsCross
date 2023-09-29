package app.external.modules

import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf

import app.data.adapters.UserAdapter

import app.framework.adapters.user.UserViewAdapter
import app.framework.adapters.message.MessageViewAdapter

val adaptersModule = module {
    // LocalDataSource
    factoryOf(::UserAdapter)

    // Views
    factoryOf(::UserViewAdapter)
    factoryOf(::MessageViewAdapter)

}
