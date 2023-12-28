package app.domain.values

import org.junit.Test
import org.junit.Assert.assertEquals

import app.domain.results.Result

internal class PasswordValueTest {
    @Test
    fun `Should return the Name when value is valid`() {
        when (val data = PasswordValue("P@ssw0rD")) {
            is Result.Failure -> {}
            is Result.Success -> {
                assertEquals("P@ssw0rD", data.success())
            }
        }
    }

    @Test
    fun `Should return message failure when Password is invalid`() {
        when (val data = PasswordValue("")) {
            is Result.Success -> {}
            is Result.Failure -> {
                assertEquals(MessagesValues.INVALID_PASSWORD.message, data.failure.message)
            }
        }
    }

    @Test
    fun `Should return message failure when Password is invalid with partial validations number character required`() {
        when (val data = PasswordValue("Pa")) {
            is Result.Success -> {}
            is Result.Failure -> {
                assertEquals(MessagesValues.INVALID_PASSWORD.message, data.failure.message)
            }
        }
    }

    @Test
    fun `Should return message failure when Password is invalid with partial validations capital character required`() {
        when (val data = PasswordValue("passw0")) {
            is Result.Success -> {}
            is Result.Failure -> {
                assertEquals(MessagesValues.INVALID_PASSWORD.message, data.failure.message)
            }
        }
    }
}
