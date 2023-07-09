package app.external.modules

import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf

import app.external.environment.Environment

fun environmentModule() = module {
    singleOf(::Environment)
}