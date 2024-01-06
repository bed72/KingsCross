package app.presentation.routes.authentication

import io.ktor.http.contentType
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode

import io.ktor.server.testing.testApplication

import io.ktor.client.request.post
import io.ktor.client.request.setBody

import app.presentation.clients.client

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.assertEquals

import app.factories.Routes
import app.factories.authentication.AuthenticationFactory

class ApplicationTest {

    private lateinit var factory: AuthenticationFactory

    @BeforeEach
    fun setUp() {
        factory = AuthenticationFactory()
    }

    @Test
    fun `Should validate the sing in return`() = testApplication {
        val response = client().post(Routes.SIGN_IN.path) {
            setBody(factory.sigInValidParameter)
            contentType(ContentType.Application.Json)
        }

        assertEquals(HttpStatusCode.OK, response.status)
    }
}
