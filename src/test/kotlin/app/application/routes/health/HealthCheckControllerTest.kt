package app.application.routes.health

import org.junit.Test

import org.junit.Assert.assertEquals

import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.client.statement.bodyAsText

import app.application.routes.withBaseTestApplication

internal class HealthCheckControllerTest {
    @Test
    fun `Should return the Health Check is Up`() = withBaseTestApplication {
        client.get("/").apply {
            val response = """
                {
                    "data": {
                        "message": "king's Cross is UP. The documentation path is /doc"
                    }
                }
            """.trimIndent()


            assertEquals(HttpStatusCode.OK, status)
            assertEquals(response, bodyAsText())
        }
    }
}
