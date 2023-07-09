package app.external.modules

import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf

import app.external.network.adapters.HttpAdapter

fun clientModule() = module {
    singleOf(::HttpAdapter)
}