package app.domain.core.models

import app.domain.entities.UserIn
import org.junit.Test
import org.junit.Assert.assertTrue
import org.junit.Assert.assertEquals

internal class UserInTest {
    @Test
    fun `Should return message failure when E-mail is invalid`() {
        val userIn = UserIn.validated(
            "bed",
            "bed@email.com",
            "Cic@da3301"
        )

        assertTrue(userIn.isLeft())
        userIn.mapLeft { messages ->
           messages.forEach { assertEquals(it.message, "'bedemail.com' should be a valid email address") }
        }
    }
}