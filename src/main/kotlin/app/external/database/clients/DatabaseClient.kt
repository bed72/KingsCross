package app.external.database.clients

import org.ktorm.database.Database

import app.external.environment.Environment

interface DatabaseClient {
    operator fun invoke(): Database
}

class DatabaseClientImpl(private val env: Environment) : DatabaseClient {
    override fun invoke() = Database
        .connect(
            url = env.get(Environment.Keys.DATABASE_URL),
            user = env.get(Environment.Keys.DATABASE_USER),
            password = env.get(Environment.Keys.DATABASE_PASSWORD),
            driver = env.get(Environment.Keys.DATABASE_DRIVER),
        )
}