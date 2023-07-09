package app.external.environment

import java.nio.file.Paths

import io.github.cdimascio.dotenv.dotenv

class Environment {
    val dotenv get() = dotenv {
        filename = ".env"
        directory = "${Paths.get("").toAbsolutePath()}/src/main/resources"
    }

    companion object {
        operator fun invoke(): Environment = Environment()
    }
}