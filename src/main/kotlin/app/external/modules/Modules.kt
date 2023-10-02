package app.external.modules

import org.koin.ktor.plugin.Koin
import org.koin.core.logger.Level
import org.koin.logger.slf4jLogger

import io.ktor.server.application.install
import io.ktor.server.application.Application

fun Application.configureModules() {
    install(Koin) {
        slf4jLogger(Level.DEBUG)

        modules(
            clientModule(),
            coroutineModule(),
            environmentModule(),
            datasourceModule,
            repositoryModule,
            useCaseModule,
            adaptersModule,
            mappersModule
        )
    }
}
