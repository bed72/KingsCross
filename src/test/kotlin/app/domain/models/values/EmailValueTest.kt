package app.domain.models.values

import org.junit.Test
import org.junit.Assert.assertEquals

import app.domain.models.ResultModel

internal class EmailValueTest {
    @Test
    fun `Should return the E-mail when value is valid`() {
        when (val data = EmailValue("email@email.com")) {
            is ResultModel.Failure -> {}
            is ResultModel.Success -> {
                assertEquals("email@email.com", data.success())
            }
        }
    }

    @Test
    fun `Should return message failure when E-mail is invalid`() {
        when (val data = EmailValue("")) {
            is ResultModel.Success -> {}
            is ResultModel.Failure -> {
                assertEquals(MessagesValues.INVALID_EMAIL.message, data.failure.message)
            }
        }
    }

    @Test
    fun `Should return message failure when E-mail is invalid with partial validations`() {
        when (val data = EmailValue("email.com")) {
            is ResultModel.Success -> {}
            is ResultModel.Failure -> {
                assertEquals(MessagesValues.INVALID_EMAIL.message, data.failure.message)
            }
        }
    }
}
