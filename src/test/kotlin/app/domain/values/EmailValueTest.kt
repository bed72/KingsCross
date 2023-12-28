package app.domain.values

import org.junit.Test
import org.junit.Assert.assertEquals

import app.domain.results.Result

internal class EmailValueTest {
    @Test
    fun `Should return the E-mail when value is valid`() {
        when (val data = EmailValue("email@email.com")) {
            is Result.Failure -> {}
            is Result.Success -> {
                assertEquals("email@email.com", data.success())
            }
        }
    }

    @Test
    fun `Should return message failure when E-mail is invalid`() {
        when (val data = EmailValue("")) {
            is Result.Success -> {}
            is Result.Failure -> {
                assertEquals(MessagesValues.INVALID_EMAIL.message, data.failure.message)
            }
        }
    }

    @Test
    fun `Should return message failure when E-mail is invalid with partial validations`() {
        when (val data = EmailValue("email.com")) {
            is Result.Success -> {}
            is Result.Failure -> {
                assertEquals(MessagesValues.INVALID_EMAIL.message, data.failure.message)
            }
        }
    }
}
