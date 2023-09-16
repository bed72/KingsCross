package app.framework.routes.authentication

import org.junit.Test
import org.junit.Assert.assertEquals

import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.HttpStatusCode
import io.ktor.client.request.post
import io.ktor.client.request.setBody

import app.framework.views.authentication.SignUpInView

import app.framework.routes.request
import app.framework.routes.withBaseTestApplication

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
