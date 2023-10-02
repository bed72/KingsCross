package app.external.modules

import org.koin.dsl.module
import org.koin.core.module.dsl.factoryOf

import app.data.adapters.UserAdapter

val adaptersModule = module {
    // LocalDataSource
    factoryOf(::UserAdapter)
}
