package app.domain.values

import org.junit.Test
import org.junit.Assert.assertEquals

import app.domain.results.Result

internal class NameValueTest {
    @Test
    fun `Should return message failure when Name is valid`() {
        when (val data = NameValue("Gabriel")) {
            is Result.Failure -> {}
            is Result.Success -> {
                assertEquals("Gabriel", data.success())
            }
        }
    }

    @Test
    fun `Should return message failure when Name is invalid`() {
        when (val data = NameValue("")) {
            is Result.Success -> {}
            is Result.Failure -> {
                assertEquals(MessagesValues.INVALID_NAME.message, data.failure.message)
            }
        }
    }

    @Test
    fun `Should return message failure when Name is invalid with partial validations`() {
        when (val data = NameValue("Ga")) {
            is Result.Success -> {}
            is Result.Failure -> {
                assertEquals(MessagesValues.INVALID_NAME.message, data.failure.message)
            }
        }
    }
}
