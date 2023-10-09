package app.domain.core.models

import app.domain.entities.User
import org.junit.Test
import org.junit.Assert.assertTrue
import org.junit.Assert.assertEquals

internal class UserTest {
    @Test
    fun `Should return message failure when E-mail is invalid`() {
        val user = User.validated(
            "bed@email.com",
            "bedemail.com"
        )

        assertTrue(user.isLeft())
        user.mapLeft { messages ->
           messages.forEach { assertEquals(it.message, "'bedemail.com' should be a valid email address") }
        }
    }
}