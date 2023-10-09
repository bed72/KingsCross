package app

import io.ktor.server.netty.EngineMain.main
import io.ktor.server.application.Application

import app.presentation.server.configureServer

import app.external.modules.configureModules

fun main(args: Array<String>) = main(args)

fun Application.configureApplication() {
    configureModules()

    configureServer()
}
