package app.external.clients

import java.nio.file.Paths

import io.github.cdimascio.dotenv.dotenv
import io.github.cdimascio.dotenv.Dotenv

interface EnvironmentClient {
    val env: Dotenv

    fun get(key: Keys): String

    enum class Keys(val key: String) {
        SUPABASE_URL("SUPABASE_URL"),
        SUPABASE_KEY("SUPABASE_KEY"),

        DATABASE_USER("DATABASE_USER"),
        DATABASE_PASSWORD("DATABASE_PASSWORD"),
        DATABASE_DRIVER("DATABASE_DRIVER"),
        DATABASE_URL("DATABASE_URL");
    }
}

class EnvironmentClientImpl : EnvironmentClient {
    override val env get() = dotenv {
        filename = ".env"
        directory = "${Paths.get("").toAbsolutePath()}/src/main/resources"
    }

    override fun get(key: EnvironmentClient.Keys): String = env.get(key.name)
}
