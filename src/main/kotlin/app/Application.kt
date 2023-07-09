package app

import io.ktor.server.cio.EngineMain.main
import io.ktor.server.application.Application

import app.framework.server.configureServer

import app.external.modules.configureModules

fun main(args: Array<String>) = main(args)

fun Application.configureApplication() {
    configureServer()
    configureModules()
}
