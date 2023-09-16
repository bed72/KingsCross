package app.external.modules

import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf

import app.external.environment.Environment
import app.external.environment.EnvironmentImpl

fun environmentModule() = module {
    singleOf(::EnvironmentImpl) bind Environment::class
}
