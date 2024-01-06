package app.domain.models.values

import org.junit.Test
import org.junit.Assert.assertEquals

import app.domain.models.ResultModel

internal class PasswordValueTest {
    @Test
    fun `Should return the Name when value is valid`() {
        when (val data = PasswordValue("P@ssw0rD")) {
            is ResultModel.Failure -> {}
            is ResultModel.Success -> {
                assertEquals("P@ssw0rD", data.success())
            }
        }
    }

    @Test
    fun `Should return message failure when Password is invalid`() {
        when (val data = PasswordValue("")) {
            is ResultModel.Success -> {}
            is ResultModel.Failure -> {
                assertEquals(MessagesValues.INVALID_PASSWORD.message, data.failure.message)
            }
        }
    }

    @Test
    fun `Should return message failure when Password is invalid with partial validations number character required`() {
        when (val data = PasswordValue("Pa")) {
            is ResultModel.Success -> {}
            is ResultModel.Failure -> {
                assertEquals(MessagesValues.INVALID_PASSWORD.message, data.failure.message)
            }
        }
    }

    @Test
    fun `Should return message failure when Password is invalid with partial validations capital character required`() {
        when (val data = PasswordValue("passw0")) {
            is ResultModel.Success -> {}
            is ResultModel.Failure -> {
                assertEquals(MessagesValues.INVALID_PASSWORD.message, data.failure.message)
            }
        }
    }
}
