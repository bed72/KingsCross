package app

import io.ktor.server.cio.EngineMain.main
import io.ktor.server.application.Application

import app.external.modules.configureModules

import app.framework.server.configureServer
import app.framework.controllers.configureControllers

fun main(args: Array<String>) = main(args)

fun Application.configureApplication() {
    configureServer()
    configureModules()
    configureControllers()
}
