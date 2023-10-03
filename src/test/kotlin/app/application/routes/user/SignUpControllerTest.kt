package app.application.routes.user

import org.junit.Test
import org.junit.Assert.assertEquals

import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.HttpStatusCode
import io.ktor.client.request.post
import io.ktor.client.request.setBody

import app.application.dtos.authentication.SignUpInView

import app.application.routes.request
import app.application.routes.withBaseTestApplication

internal class SignUpControllerTest {
    @Test
    fun `Should return failure when try sign up`() = withBaseTestApplication {

        val response = request().post("/v1/authentication/sign/up") {
            contentType(ContentType.Application.Json)
            setBody(SignUpInView("Gabriel Ramos", "email@email.com", "P@ssw0rD"))
        }

        assertEquals(HttpStatusCode.BadRequest, response.status)
    }
}
