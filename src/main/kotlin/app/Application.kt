package app

import io.ktor.server.netty.EngineMain.main
import io.ktor.server.application.Application

import app.external.modules.configureModules

import app.presentation.server.configureServer

fun main(args: Array<String>) = main(args)

fun Application.configureApplication() {
    configureModules()

    configureServer()
}
