package app.external.clients.database

import app.external.clients.evironment.EnvironmentClient
import org.ktorm.database.Database

interface DatabaseClient {
    val of: Database
}

class DatabaseClientImpl(private val env: EnvironmentClient) : DatabaseClient {
    override val of: Database get() = Database
            .connect(
                generateSqlInUpperCase = true,
                alwaysQuoteIdentifiers = true,
                url = env.get(EnvironmentClient.Keys.DATABASE_URL),
                user = env.get(EnvironmentClient.Keys.DATABASE_USER),
                driver = env.get(EnvironmentClient.Keys.DATABASE_DRIVER),
                password = env.get(EnvironmentClient.Keys.DATABASE_PASSWORD)
            )
}