package app.framework.controllers.authentication

import org.junit.Test
import org.junit.Assert.assertEquals

import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.HttpStatusCode
import io.ktor.client.request.post
import io.ktor.client.request.setBody

import app.framework.views.authentication.SignUpInView
import app.framework.controllers.withBaseTestApplication

class AuthenticationControllerTest {
    @Test
    fun `Should return the Health Check is Up`() = withBaseTestApplication {

        val response = client.post("/v1/authentication/sign/up") {
            contentType(ContentType.Application.Json)
            setBody(SignUpInView("Gabriel Ramos", "email@email.com", "P@ssw0rD"))
        }

        assertEquals(HttpStatusCode.Created, response.status)
    }
}