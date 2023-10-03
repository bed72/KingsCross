package app.application.routes.user


import org.junit.Test
import org.junit.Assert.assertEquals

import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.HttpStatusCode
import io.ktor.client.request.post
import io.ktor.client.request.setBody

import app.application.dtos.authentication.SignInInView

import app.application.routes.request
import app.application.routes.withBaseTestApplication

internal class SignInControllerTest {
    @Test
    fun `Should return failure when try sign in`() = withBaseTestApplication {

        val response = request().post("/v1/authentication/sign/up") {
            contentType(ContentType.Application.Json)
            setBody(SignInInView("email@email.com", "P@ssw0rD"))
        }

        assertEquals(HttpStatusCode.BadRequest, response.status)
    }

}
